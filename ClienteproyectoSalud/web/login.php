<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        $dbhost = "localhost";
        $dbuser = "root";
        $dbpass = "";
        $dbname = "test";

        $conn = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);
        if (!$conn) {
            die("No hay conexión: " . mysqli_connect_error());
        }

        $nombre = $_POST["txtusuario"];
        $pass = $_POST["txtpassword"];

        $query = mysqli_query($conn, "SELECT * FROM login WHERE usuario = '" . $nombre . "' and password = '" . $pass . "'");
        $nr = mysqli_num_rows($query);

        if ($nr == 1) {
            //header("Location: pagina.html")
             header("Location: index.html");
            echo "Bienvenido:" . $nombre;
        } else if ($nr == 0) {
            header("Location: index.html");
            //echo "No ingreso"; 
            echo "index.html";
        }
        ?>
    </body>
</html>
