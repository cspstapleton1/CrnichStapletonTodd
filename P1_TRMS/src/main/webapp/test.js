
  
<?php
session_start(); 
?>
<!DOCTYPE html>
<html>
<title></title>
<link rel="stylesheet" href="./css/style1.css">
<header>
	 <div class="container">
        <div id="branding">
          <h1><span class="highlight">Triple M</span> Studios</h1>
        </div>
        <nav>
          <ul>
             <li><a href="index.php">Home</a></li>
            <li><a href="about.php">About</a></li>
            <li><a href="services.php">Services</a></li>
          </ul>
        </nav>
      </div>

</header>


<body>

 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
<script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
<body>
<div class="container">
  <div class="row">

    <h2 class="text-center">Days Opened</h2>
  </div>
    
        <div class="row">
    
            <div class="col-md-12">



            
            
<table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
              <th>Hours</th>
              <th>Start Time</th>    
              <th>Date</th>
              
                            
            </tr>
          </thead>

          <tfoot>
            <tr>
              <th>Hours</th>
              <th>Start Time</th>
              <th>Date</th>
              

                            
            </tr>
          </tfoot>

          <tbody>
            
              <?php
              include "db_connect.php";
          
  $sql = "SELECT * FROM opened";
  $stmt = mysqli_stmt_init($mysqli);
    if(!mysqli_stmt_prepare($stmt,$sql)){
    echo"sql statement failed";
                    }
 
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);
    if(!$row = $result){
      echo "no a day able to be schduled";
    }
      else{
while($row = mysqli_fetch_assoc($result)){
        $date = $row["datee"];
         $hours = $row["hours"];
          $time = $row["timee"];
        $hours = $row["hours"];
       
echo "<td>$hours</td>
                   
              <td>$time </td>
                <td>  $date </td> </tr>";
}}
              ?>
                            
            </tr>
          </tbody>
        </table>
    <h2 class="text-center">Offical Studio Time</h2>
        <table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
            <th>Name</th>
              <th>Start Time</th>       
              <th>Hours</th>
              <th>Date</th>
              
                            
            </tr>
          </thead>

          <tfoot>
            <tr>
              <th>Name</th>
              <th>Start Time</th>
              <th>Hours</th>
              <th>Date</th>
              

                            
            </tr>
          </tfoot>

          <tbody>
            
             <?php
              include "db_connect.php";
          
  $sql = "SELECT * FROM taken";
  $stmt = mysqli_stmt_init($mysqli);
    if(!mysqli_stmt_prepare($stmt,$sql)){
    echo"sql statement failed";
                    }
 
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);
    if(!$row = $result){
      echo "no a day able to be schduled";
    }
      else{
while($row = mysqli_fetch_assoc($result)){
      $name = $row["name"];
        $date = $row["datee"];
         $hours = $row["hours"];
          $time = $row["timee"];
        $hours = $row["hours"];
       
echo "<td>$name</td>
                   <td>$hours</td>
              <td>$time </td>
                <td>  $date </td> </tr>";
}}
              ?>
                            
            </tr>
          </tbody>
        </table>
        <?php
        if(isset($_SESSION['Name'])){ echo'
    <h2 class="text-center">Your Days </h2>
        <table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
            
              <th>Start Time</th>       
              <th>Hours</th>
              <th>Date</th>
              
                            
            </tr>
          </thead>
          <tfoot>
            <tr>
    
              <th>Start Time</th>
              <th>Hours</th>
              <th>Date</th>
              
                            
            </tr>
          </tfoot>
          <tbody>';}
            
             
             if(isset($_SESSION['Name'])){
              include "db_connect.php";
          
  $sql = "SELECT * FROM taken WHERE name =? ";
  $stmt = mysqli_stmt_init($mysqli);
    if(!mysqli_stmt_prepare($stmt,$sql)){
    echo"sql statement failed";
                    }
 
 $Name =$_SESSION['Name'];
  mysqli_stmt_bind_param($stmt,"s", $Name);
    mysqli_stmt_execute($stmt);
    $result = mysqli_stmt_get_result($stmt);
    if(!$row = $result){
      echo " <td>you have no days </td>";
    }
      else{
while($row = mysqli_fetch_assoc($result)){
        $date = $row["datee"];
         $hours = $row["hours"];
          $time = $row["timee"];
        $hours = $row["hours"];
       
echo "
                   <td>$hours</td>
              <td>$time </td>
                <td>  $date </td> </tr>";
}
}}
              ?>
                            
            </tr>
          </tbody>
        </table>

         <?php
if(isset($_SESSION['Name'])){
  $name =$_SESSION['Name'];
  $email =$_SESSION['Email'];
  $superuser =$_SESSION['superuser'];
echo'  <h2 class="text-center">Delete Days you have</h2>
<form action ="userdelete.php" method="post" id="rendered-form"><div class="rendered-form"><div >
<label " "></label><input name="Name" class="form-control" id="Name" type="hidden" maxlength="30" value="'.$name.'"></div>
            <div class="form-group">
                <input type="text" name="dateee" required="required" id="txtDate" class="form-control input-lg" placeholder="Date">
              </div>
<div class="fb-text form-group field-Email"><button name="submit" id="submit"value="Submit" type="submit"class="btn btn-primary btn-lg">Submit</button></div></div>
</form>
'; 
echo' 
 <h2 class="text-center">sign up here</h2>
 <form action ="studioschudule.php" method="post" id="rendered-form"><div class="rendered-form"><div >
<label " "></label><input name="Name" class="form-control" id="Name" type="hidden" maxlength="30" value="'.$name.'"></div>
<div class="fb-text form-group field-Email"><label class="fb-text-label" for="emaill"></label><input name = "emaill" class="form-control" id="Email" aria-required="true" required="required" type="hidden" maxlength="35"  value="'.$email.'"placeholder="Email"></div>
            <div class="input-group input-append date" id="datePicker">
                <input type="text" required="required" class="form-control" name="date" />
                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                
            </div>
<div class="fb-text form-group field-Email"><button name="submit" id="submit"value="Submit" type="submit"class="btn btn-primary btn-lg">Submit</button></div></div>
</form>
'; 
if( $superuser == "true"){
echo'  <h2 class="text-center">Add To Days Opened</h2>
<form action ="newopwnedday.php" method="post" id="rendered-form"><div class="rendered-form"><div >
 <div class="form-group">
                <input type="text" name="starttime"  required="required"id="starttime" class="form-control input-lg" placeholder="Start Time">
              </div>
                <div class="form-group">
                <input type="text" name="hours" required="required" id="hours" class="form-control input-lg" placeholder="Hours">
              </div>
            <div class="form-group">
                <input type="text" name="datee" required="required" id="datee" class="form-control input-lg" placeholder="Date">
              </div>
<div class="fb-text form-group field-Email"><button name="submit" id="submit"value="Submit" type="submit"class="btn btn-primary btn-lg">Submit</button></div></div>
</form>
'; 
echo'  <h2 class="text-center">Delete Days Opened</h2>
<form action ="delete.php" method="post" id="rendered-form"><div class="rendered-form"><div >
            <div class="form-group">
                <input type="text" name="dateee" required="required" id="dateee" class="form-control input-lg" placeholder="Date">
              </div>
<div class="fb-text form-group field-Email"><button name="submit" id="submit"value="Submit" type="submit"class="btn btn-primary btn-lg">Submit</button></div></div>
</form>
'; 
echo'  <h2 class="text-center">Kick Date</h2>
<form action ="kick.php" method="post" id="rendered-form"><div class="rendered-form"><div >
 <div class="form-group">
                <input type="text" name="date"  required="required"id="date" class="form-control input-lg" placeholder="Date">
              </div>
            <div class="form-group">
                <input type="text" name="name" required="required" id="name" class="form-control input-lg" placeholder="Name">
              </div>
<div class="fb-text form-group field-Email"><button name="submit" id="submit"value="Submit" type="submit"class="btn btn-primary btn-lg">Submit</button></div></div>
</form>
'; 
echo'  <h2 class="text-center">THE BAN BUTTON</h2>
<form action ="ban.php" method="post" id="rendered-form"><div class="rendered-form"><div >
 <div class="form-group">
                <input type="text" name="name"  required="required"id="name" class="form-control input-lg" placeholder="Name of User to be banned">
              </div>
           
<div class="fb-text form-group field-Email"><button name="submit" id="submit"value="Submit" type="submit"class="btn btn-primary btn-lg">BAN</button></div></div>
</form>
'; 
}
}?>

  
  </div>
  </div>
</div>


    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>
    </body>
<br>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
  <div class="row">
      <!-- Include Bootstrap Datepicker -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />








<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>


    
<script>
$(document).ready(function() {
    $('#datePicker')
        .datepicker({
            format: 'mm-dd-yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            $('#eventForm').formValidation('revalidateField', 'date');
        });
    $('#eventForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: 'The name is required'
                    }
                }
            },
            date: {
                validators: {
                    notEmpty: {
                        message: 'The date is required'
                    },
                    date: {
                        format: 'MM/DD/YYYY',
                        message: 'The date is not a valid'
                    }
                }
            }
        }
    });
});
</script>
<script type="text/javascript" src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js'></script>
<script type="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js'></script>
<link rel="stylesheet" href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/css/bootstrap.min.css'
    media="screen" />
<!-- Bootstrap -->
<!-- Bootstrap DatePicker -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css" type="text/css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js" type="text/javascript"></script>
<!-- Bootstrap DatePicker -->
<script type="text/javascript">
    $(function () {
        $('[id*=txtDate]').datepicker({
            changeMonth: true,
            changeYear: true,
            format: "mm-dd-yyyy",
            language: "tr"
        });
    });
</script>
  </div>
</div>


</body>


















































<footer>
      <p>Killer Web Deisgn, Copyright &copy; 2019</p>
    </footer>

</html>

© 2019 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
