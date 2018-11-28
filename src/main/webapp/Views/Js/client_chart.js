/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
          ['Client', "Chiffre d'affaire"],
          ["Client 1", 1400],
          ["Client 2", 750],
          ["Client 3", 2200],
          ["Client 4", 720],
          ["Client 5", 640],
          ["Client 6", 1450],
          ["Client 7", 3100],
          ["Client 8", 780],
        ]);

        var options = {
          title: "Chiffre d'affaire par client",
          width: 900,
          legend: { position: 'none' },
          chart: { title: "Chiffre d'affaire par client",
                   subtitle: 'Durant la periode [PERIODE]' },
          bars: 'horizontal', // Required for Material Bar Charts.
          axes: {
            x: {
              0: { side: 'top', label: "Chiffre d'affaire en €"} // Top x-axis.
            }
          },
          bar: { groupWidth: "90%" }
        };

        var chart = new google.charts.Bar(document.getElementById('client_chart'));
        chart.draw(data, options);
      };