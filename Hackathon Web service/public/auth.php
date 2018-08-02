<?php

  
    $con = mysqli_connect('localhost','root','') 
        or die('Cannot connect to the DB');
    mysqli_select_db($con,'tiaret_team');


    $response = array();

    if(isset($_POST['name']) &&  isset($_POST['passport']) && isset($_POST['type'])){
        $name = $_POST['name'];
        $passport = $_POST['passport'];
        $type = $_POST['type'];

        $query = ""  ;    
    
    switch($type){
        case 1:
        $query = "SELECT * FROM hajj WHERE name='$name' and passport_number='$passport'"  ;
        break;
        case 2:
        $query = "SELECT * FROM health_assitante WHERE name='$name'and passport_number='$passport'"  ; 
        break;
        case 3:
        $query = "SELECT * FROM assistant WHERE name='$name'and passport_number='$passport'"  ;  
        break;
        case 4:
        $query = "SELECT * FROM guide WHERE name='$name'and passport_number='$passport'"  ;  
        break;
    } 
  
  $result=mysqli_query($con,$query);

      if(($result->num_rows) > 0)    {

          $d= mysqli_fetch_array($result);
          $response["data"] =$result;
          
          
          // success
          $response["status"] = 200;
          

      } else {
        $response["status"] = 401;
      }
      
      echo(json_encode($response));


  
    } else {
        $response['status'] = 400;
    }

    


?>