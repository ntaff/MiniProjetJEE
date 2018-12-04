     /* 
    Created on : 28 nov. 2018, 14:14:19
    Author     : Taffoureau
*/
/* global google */

// Load google charts
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {
        var data = new google.visualization.arrayToDataTable([
          ['Zone Géographique', "Chiffre d'affaire"],
          ["State 1", 1400],
          ["State 2", 750],
          ["State 3", 2200],
          ["State 4", 720],
          ["State 5", 640],
          ["State 6", 1450],
          ["State 7", 3100],
          ["State 8", 780],
        ]);

        var options = {
          title: "Chiffre d'affaire par zone géographique",
          width: 900,
          legend: { position: 'none' },
          chart: { title: "Chiffre d'affaire par zone géographique",
                   subtitle: 'Durant la periode [PERIODE]' },
          bars: 'horizontal', // Required for Material Bar Charts.
          axes: {
            x: {
              0: { side: 'top', label: "Chiffre d'affaire en €"} // Top x-axis.
            }
          },
          bar: { groupWidth: "90%" }
        };

        var chart = new google.charts.Bar(document.getElementById('geochart'));
        chart.draw(data, options);
      };



/*
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

       data.addRows([[37.337842, -121.898454,'CA']]); //Californie
       data.addRows([[39.960608, -82.998998,'CA']]); //Ohio
       data.addRows([[41.876369, -87.626709,'CA']]); //Illinois
       data.addRows([[41.577927, -93.623050,'CA']]); //Iowa
       data.addRows([[37.540095, -77.436921,'CA']]); //Virginie
       data.addRows([[42.333550, -71.063662,'CA']]); // Massachussets
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
    }; */