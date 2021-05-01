package dev.atharvakulkarni.midas;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Database
{
    FirebaseFirestore db;

    Map<String, String> map = new HashMap<String, String>();
    int i=1;

    List<String> list;

    List<String> getData(String village,String screen,List<String> input)
    {
        db = FirebaseFirestore.getInstance();

       // Log.d("a",  village);


       /* db.collection(village).document()
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    private static final String TAG = "a";

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if (task.isSuccessful())
                        {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                               // if(document.getId().equals(screen))
                                {

                                    //values.add(document.getString(key));
                                   // Log.d(TAG, document.getId() + " => " + document.getData());

                                    map.putAll(document.getData());
                                }
                            }


                        }
                        else
                        {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });*/

        /*db.collection(village).document(screen)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if(task.isSuccessful())
                        {
                            for(QueryDocumentSnapshot document : task.getResult())
                            {
                               // Log.d(TAG,document.getId() + " => " + document.getData());

                                // if(document.getId().equals(screen))
                                {

                                    //values.add(document.getString(key));
                                    // Log.d("TAG", document.getId() + " => " + document.getData());

                                    //map.putAll(document.);

                                   // DatabasePOJO pojo = document.toObject(DatabasePOJO.class);
                                   // Log.d("TAG", pojo.getData());
                                }
                            }
                        }
                        else
                        {
                            //Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });*/



        DocumentReference docRef = db.collection("कोनांबे").document("होम");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            private static final String TAG = "a";

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if (task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();
                    //if (document.exists())
                    //{
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                       // map.putAll(Objects.requireNonNull(document.getData()));

                   // DatabasePOJO databasePOJO = new DatabasePOJO();

                    //databasePOJO.setValue(document.se);

                   // }
                   // else
                   // {
                    //    Log.d(TAG, "No such document");
                    //}

                   // list.add(document.getString(input.get(0))+"x ");

                    Log.d(TAG, "DocumentSnapshot data: " + document.getString(input.get(i))+"  "+i);
                    i++;
                }
                else
                {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

        /*docRef
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>()
                {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot)
                    {
                        if(documentSnapshot.exists())
                        {
                            Log.d("MyLogger", "Empty Document!");
                        }
                        else
                        {
                            // Get all fields to a list
                           // List<MyModel> types = documentSnapshots.toObjects(MyModel.class);

                          //  map.putAll(Objects.requireNonNull(documentSnapshot.getData()));

                            Log.i("LOGGER","Born "+documentSnapshot.getString("वापरलेल पाणी"));
                        }
                    }
                });*/


      /*  //asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = db.collection("cities").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<String> titles=new ArrayList<>();
        for (QueryDocumentSnapshot document : documents)
        {
            titles.add(document.getString("title")); //this will get titles and add into titles list.
        }*/

        return list;

       // Log.d("TAG", map.get("वापरलेल पाणी"));
    }
}
