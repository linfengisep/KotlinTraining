package isep.stageoutilsconteneur;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/**
 * Created by linfengwang on 25/01/2018.
 */

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private static final String TAG="MapActivity";
    private FusedLocationProviderClient mFusedLocaitonProviderClient;
    private static final float DEFAULT_ZOOM=15;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
    }

    private void getDeviceLocation(){
        Log.d(TAG,"getDeviceLocation: getting the current devices location");
        mFusedLocaitonProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try{
           Task location = mFusedLocaitonProviderClient.getLastLocation();
            location.addOnCompleteListener(new OnCompleteListener(){
                @Override
                public void onComplete(@Nullable Task task){
                    if(task.isSuccessful()){
                        Log.d(TAG,"onComplete:Found lcoation");
                        Location currentLocation=(Location)task.getResult();

                        moveCamera(new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude()),DEFAULT_ZOOM);
                    }else{
                        Log.d(TAG,"onComplete:current locaiton is null");
                    }
                }
            });
        }catch (SecurityException e){
            Log.e(TAG,"getDeviceLocaiton:SecurityException:"+e.getMessage());
        }
    }

    private void moveCamera(LatLng latLng, float zoom){
        Log.d(TAG,"moveCamera:moving the camera to:lat:"+latLng.latitude+", lng:"+latLng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Toast.makeText(this,"Map is ready",Toast.LENGTH_SHORT).show();
        getDeviceLocation();
    }
}
