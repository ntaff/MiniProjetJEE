     /* 
    Created on : 28 nov. 2018, 14:14:19
    Author     : Taffoureau
*/
/* global google */

// Load google charts
            google.charts.load('current', {
                'packages': ['geochart'],
                'mapsApiKey': 'AIzaSyBIJMcD8XxmKegQZQM1CE7mDhzGDgpuAI0'
            });
            google.charts.setOnLoadCallback(drawRegionsMap);
            function drawRegionsMap() {
                var data = google.visualization.arrayToDataTable([
                    ['States', "Chiffre d'affaire"],
                    ['CO', 900],
                    ['NM', 3500],
                    ['NY', 4000],
                    ['AZ', 1250],
                    ['AR', 2400],
                    ['MS', 1700],
                    ['NH', 1900],
                    ['WA', 2100],
                    ['IL', 1700],
                    ['MT', 1900],
                    ['ND', 2100],
                    ['KS', 1900],
                    ['VA', 2100],
                    
          /*  <c:forEach var="ca" items="${chiffresZone}">
                    ['${ca.nom}', ${ca.total}],
            </c:forEach> */
                ]);
                var options2 = {
                    title: "Chiffre d'affaire par zone géographique",
                    width: 900, 
                    height: 500, 
                    region: "US", 
                    resolution: "provinces",
                    backgroundColor: '#FFFFF'};
                var chart = new google.visualization.GeoChart(document.getElementById('geochart'));
                chart.draw(data, options2);
            }