//package com.example.pritjoshi.prit_project1;
//
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//
//import java.util.ArrayList;
//
//public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
//
//    private SQLiteDatabase mSQLiteDatabase;
//    private GoogleMap mMap;
//    private ArrayList<MyLocations> locations;
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater mi = getMenuInflater();
//        mi.inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.itemNew:
//                Intent i = new Intent(MapsActivity.this, InputActivity.class);
//                startActivity(i);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mSQLiteDatabase = DBSingleton.getDatabase(getApplicationContext());
//        locations = getLocationList();
//    }
//
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        // Add a marker in Sydney and move the camera
//        for (MyLocations ml : locations) {
//            LatLng coord = new LatLng(ml.getmLatitude(), ml.getmLongitude());
//            mMap.addMarker(new MarkerOptions().position(coord).title(ml.getmTitle()).snippet(ml.getmDescription()));
//        }
//        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 15));
//                return false;
//            }
//        });
//    }
//
//    private MyLocationsCursorWrapper queryLocations() {
//        Cursor cursor = mSQLiteDatabase.query(
//                DBSchema.LocationTable.NAME,
//                null,
//                null,
//                null,
//                null,
//                null,
//                null);
//        return new MyLocationsCursorWrapper(cursor);
//    }
//    public ArrayList<MyLocations> getLocationList() {
//        ArrayList<MyLocations> myLocationList = new ArrayList<>();
//        MyLocationsCursorWrapper cursor = queryLocations();
//        try {
//            cursor.moveToFirst();
//            while(!cursor.isAfterLast()) {
//                myLocationList.add(cursor.getLocation());
//                cursor.moveToNext();
//            }
//        }
//        finally {
//            cursor.close();
//        }
//        return myLocationList;
//    }
//}