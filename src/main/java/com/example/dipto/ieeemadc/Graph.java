package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class Graph extends AppCompatActivity {
    private GraphView grapher;
    private LineGraphSeries<DataPoint> series;
    private Viewport viewport;
    private float maxOfX = -9999999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        GraphView grapher = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        grapher.addSeries(series);
        viewport = grapher.getViewport();
        viewport.setScrollable(true);
    }

    public void onAddPoint(View view){
        if(view.getId()==R.id.addPointButton) {
            EditText stringX = (EditText) findViewById(R.id.inputX);
            EditText stringY = (EditText) findViewById(R.id.inputY);
            float X = Float.parseFloat(stringX.getText().toString());
            float Y = Float.parseFloat(stringY.getText().toString());
            if(X>=maxOfX){
                series.appendData(new DataPoint(X,Y),true, 100);
                maxOfX=X;
            }
            else{
                Toast inform = Toast.makeText(Graph.this,"X-axis input is not valid(must be greater than last input)",Toast.LENGTH_SHORT);
                inform.show();
            }
        }
    }




}
