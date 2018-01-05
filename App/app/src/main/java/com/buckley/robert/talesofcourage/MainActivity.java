package com.buckley.robert.talesofcourage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> urls = new ArrayList<String>();
    ArrayList<Dog> dogs = new ArrayList<Dog>();
    String currentUrl;
    int num = 0;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        Firebase fire = new Firebase("https://tales-of-courage.firebaseio.com/");
        listView = (ListView)findViewById(R.id.listView);

        fire.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                num++;
                Dog current = dataSnapshot.getValue(Dog.class);
                currentUrl = current.getimgUrl();
                urls.add("http://" + currentUrl);
                dogs.add(current);
                System.out.println(currentUrl);

                listView.setAdapter(new ImageListAdapter(MainActivity.this, urls.toArray(new String[urls.size()])));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog l = new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Age: " + dogs.get(position).getAge() + "\n" + "Breed: " + dogs.get(position).getBreed() + "\n" + "Size: " + dogs.get(position).getSize())
                        .setTitle(dogs.get(position).getName())
                        .create();
                l.show();

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.commandments:
                Toast.makeText(this, "Commandments selected", Toast.LENGTH_SHORT).show();
                AlertDialog l = new AlertDialog.Builder(MainActivity.this).setMessage("1. We are powerless to overcome alone.  We submit to a higher power that will restore us. We accept help from fellow members, volunteers and team mates in our struggle, and we make a decision to put the lives of others before our own.\n" +
                        "2. We constantly create a changing inventory of ourselves, the organization, and how we can help those we serve.  We welcome new ideas, and foster a safe environment for innovation.\n" +
                        "3. Animals and people will get scared, they will get upset, and feelings sometimes get hurt.  Together, we learn those lessons, and move on.  We do not pray for the mountain to move, we pray for the strength to climb it.\n" +
                        "4. Everything can be forgiven.  We forgive those who harm us, those who have harmed the animals for whom we will care, and most importantly, we forgive ourselves.\n" +
                        "5. We make mistakes, and respect our mistakes.  Rescue is a living, breathing and changing entity.  We listen to the mistakes made by others, and are not afraid to share our mistakes.  We are dealing with living creatures and everything we learn should be passed on to help one another.\n" +
                        "6. We do not tolerate judgment,  gossip, bullying in any form or harm to the organization.  No judgment, just rescue.  Anyone not following this commandment will be forgiven, and asked to leave.  \n" +
                        "7. We embrace all differences, challenges and fears. We welcome all volunteers as friends – all ages, backgrounds, religious beliefs, special needs – physical and emotional.  We maintain a safe environment for ourselves and others.  We work with animals to overcome together.\n" +
                        "8. Everyone contributes.  Everyone picks up poop, gets dirty, messy and lends a hand to one another, no matter what.  \n" +
                        "9. We accept that with life, there also comes death.  We can not save every animal, but we will give the ones we do save the best possible life we know how.  Grieve for the lost and celebrate the saved.  \n" +
                        "10. We believe in miracles and the impossible, and strive for them daily.").setTitle("The Ten Commandments").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create();
                        l.show();

                break;
            case R.id.contact:
                Toast.makeText(this, "Contacts selected", Toast.LENGTH_SHORT).show();
                AlertDialog ad = new AlertDialog.Builder(MainActivity.this).setMessage("Phone: 877-63-TAILS \nMailing Adress: 39 Smith Street, Danbury, CT 06810 \nWebsite (donate and adopt): http://tailsofcourage.org/").setTitle("Contact").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create();
                ad.show();
                break;
            case R.id.map:
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
            case R.id.about:
                Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show();
                AlertDialog aboutd = new AlertDialog.Builder(MainActivity.this).setMessage("Tails of Courage is a Christian based national non-profit organization committed to helping our communities. Founded in 2009, by a survivor of the World Trade Center attacks in New York City on September 11th, 2001, in an effort to honor the heroes lost in the tragedy, the mission of the organization is to help as much as possible with various programs within the communities we serve. We welcome everyone, from all walks of life, all beliefs, all backgrounds, and want to have a positive impact on the world around us.\n" +
                        " \n" +
                        "We are entirely funded by donations and depend on volunteers.  At present, Tails of Courage has Chapters in Connecticut, Pennsylvania, West Virginia and California.  We allow and even encourage children under the age of 18 to volunteer with the shelter dogs and cats.  All children, regardless of age, may volunteer with Tails of Courage.  Children under 13 must have an adult accompany them.  We have partnered with local schools for children to obtain their community service, and most importantly to learn about the care of animals.  Families volunteer together.\n" +
                        " \n" +
                        "Our CT Chapter is home to our animal shelter located at 39 Smith Street, Danbury, CT 06810.  Our adoption hours are every day from 9:30 AM – 5:00 PM.  You do not need an appointment. We are always happy to answer any questions about adopting a new pet and will gladly provide any support you may need throughout the adoption process.\nEmail us at info@tailsofcourage.org for more information.").setTitle("About").setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).create();
                aboutd.show();
                break;


        }
        return true;
    }

}
