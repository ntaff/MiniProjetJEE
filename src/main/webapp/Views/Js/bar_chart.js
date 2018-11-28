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
          ['Catégorie', "Chiffre d'affaire"],
          ["Produit 1", 1400],
          ["Produit 2", 750],
          ["Produit 3", 2200],
          ["Produit 4", 720],
          ["Produit 5", 640],
          ["Produit 6", 1450],
          ["Produit 7", 3100],
          ["Produit 8", 780],
        ]);

        var options = {
          title: "Chiffre d'affaire par catégorie d'articles",
          width: 900,
          legend: { position: 'none' },
          chart: { title: "Chiffre d'affaire par catégorie d'articles",
                   subtitle: 'Durant la periode [PERIODE]' },
          bars: 'horizontal', // Required for Material Bar Charts.
          axes: {
            x: {
              0: { side: 'top', label: "Chiffre d'affaire en €"} // Top x-axis.
            }
          },
          bar: { groupWidth: "90%" }
        };

        var chart = new google.charts.Bar(document.getElementById('chart'));
        chart.draw(data, options);
      };