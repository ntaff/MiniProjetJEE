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
          ['Catégorie 1', 6500],
          ['Catégorie 2', 8500],
          ['Catégorie 3', 4000],
          ['Catégorie 4', 5000],
       /* <c:forEach var="ca" items="${caCat}">
            ['${ca.nom}', ${ca.total}],
        </c:forEach> */
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