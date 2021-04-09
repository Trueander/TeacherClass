google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);


function drawChart() {
    var usuarios = document.getElementById("usuarios");
    var encuestas = document.getElementById("encuestas");
    
    var usuariosValue = usuarios.innerText;
    var encuestasValue = encuestas.innerText;

  var data = google.visualization.arrayToDataTable([
	  ['Titulo', 'Cantidad'],
	  ['Positivo',    parseInt(encuestasValue)],
    ['Negativo',    parseInt(usuariosValue)]
  ]);

  var options = {
    pieStartAngle: 100,
    title: 'PUNTAJE',
    is3D: true,
    slices: {
      0: { color: '#1ef5ad' },
      1: { color: '#ff5364' }
    },
    backgroundColor: "transparent",
    titleTextStyle: { color: "#fff",
            fontSize: "20px",
            bold: true
          }
  };

  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);

  chart.draw(data, options);
}