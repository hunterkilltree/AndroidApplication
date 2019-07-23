import 'package:flutter/material.dart';
import 'package:firebase_database/firebase_database.dart';
import 'package:firebase_database/ui/firebase_animated_list.dart';


void main() => runApp(MyApp());


class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData.dark(),
      home: Home(),
    );
  }
}

class Home extends StatefulWidget {
  @override
  HomeState createState() => HomeState();
}


class HomeState extends State<Home> {
  double t;
  double h;

  final databaseReference = FirebaseDatabase.instance.reference();

  void getData(){

    databaseReference.once().then((DataSnapshot snapshot) {

      setState(() {
        t = snapshot.value['Temperature'];
        h = snapshot.value['Humidity'];
      });

      //data = snapshot.value("Temperature");
      print("T : ${t}");
      print('Data : ${snapshot.value['Temperature']}');
      print('Data : ${snapshot.value['Humidity']}');
    });

  }


  List<Item> items = List();
  Item item;
  DatabaseReference itemRef;


  final GlobalKey<FormState> formKey = GlobalKey<FormState>();
  @override
  void initState() {
    super.initState();
    item = Item("", "");
    final FirebaseDatabase database = FirebaseDatabase.instance; //Rather then just writing FirebaseDatabase(), get the instance.
    itemRef = database.reference().child('items');
    itemRef.onChildAdded.listen(_onEntryAdded);
    itemRef.onChildChanged.listen(_onEntryChanged);
  }

  _onEntryAdded(Event event) {
    setState(() {
      items.add(Item.fromSnapshot(event.snapshot));
    });
  }

  _onEntryChanged(Event event) {
    var old = items.singleWhere((entry) {
      return entry.key == event.snapshot.key;
    });
    setState(() {
      items[items.indexOf(old)] = Item.fromSnapshot(event.snapshot);
    });
  }

  void handleSubmit() {
    final FormState form = formKey.currentState;

    if (form.validate()) {
      form.save();
      form.reset();
      itemRef.push().set(item.toJson());
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('project'),
      ),
      resizeToAvoidBottomPadding: false,
      body: Column(
        children: <Widget>[
          Flexible(
            flex: 0,
            child: Center(
              child: Form(
                key: formKey,
                child: Flex(
                  direction: Axis.vertical,
                  children: <Widget>[
                    Text(' Temperature: ${t}' ),
                    Text('Humidity: ${h}'),
                    RaisedButton(
                      child: Text('View Record'),
                      onPressed: getData,
                    ),

                  ],
                ),
              ),
            ),
          ),
          Flexible(
            child: FirebaseAnimatedList(
              query: itemRef,
              itemBuilder: (BuildContext context, DataSnapshot snapshot,
                  Animation<double> animation, int index) {
                return new ListTile(
                  leading: Icon(Icons.message),
                  title: Text(items[index].title),
                  subtitle: Text(items[index].body),
                );
              },
            ),
          ),
        ],
      ),
    );
  }

}

class Item {
  String key;
  String title;
  String body;

  Item(this.title, this.body);

  Item.fromSnapshot(DataSnapshot snapshot)
      : key = snapshot.key,
        title = snapshot.value["title"],
        body = snapshot.value["body"];

  toJson() {
    return {
      "title": title,
      "body": body,
    };
  }
}

