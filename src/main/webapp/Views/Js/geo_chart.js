/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


     google.charts.load('current', {
       'packages': ['geochart'],
       'mapsApiKey': 'AIzaSyBIJMcD8XxmKegQZQM1CE7mDhzGDgpuAI0'
     });
     google.charts.setOnLoadCallback(drawMarkersMap);

      function drawMarkersMap() {
      var data = new google.visualization.DataTable();

        data.addColumn('number', 'Lat');                                
        data.addColumn('number', 'Long');
        //data.addColumn({type:'string', role:'Zip'});
        data.addColumn({type:'string', role:'CA'});                        

       data.addRows([[37.360067, -121.981425,'CA']]);
       data.addRows([[38.428647, -112.072188,'CA']]);
       data.addRows([[42.713168, -110.068334,'CA']]);
       data.addRows([[39.101918, -94.579805,'CA']]);
       data.addRows([[41.160482, -86.781222,'CA']]);
       data.addRows([[30.266822, -97.744760,'CA']]);
       data.addRows([[38.903507, -77.036618,'CA']]);
       data.addRows([[40.709369, -74.007113,'CA']]);
       data.addRows([[36.170276, -85.140559,'CA']]);
       data.addRows([[33.444510, -102.080303,'CA']]);
       data.addRows([[45.782540, -101.501188,'CA']]);

      var options = {
        region: 'US',
        displayMode: 'markers',
        colorAxis: {colors: ['yellow', 'red']}
      };

      var chart = new google.visualization.GeoChart(document.getElementById('geo_chart'));
      chart.draw(data, options);
    };