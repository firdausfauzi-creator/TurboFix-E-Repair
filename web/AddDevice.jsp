<%@page import="Class.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TurboFix E-Repair System</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">TurboFix E-Repair System</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">

                        <li class="divider"></li>
                    
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->

                
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                      
                        <li>
                            <a href="StaffHome.jsp"><i class=""></i> Home</a>
                        </li>
                        <li>
                            <a href="ViewCustomerProfile"><i class=""></i>Customer Profile List</a>
                        </li>
                        <li>
                            <a href="ViewAllRepairList?Status=staff"><i class=""></i>Repair Request List</a>
                        </li>
                        <li>
                            <a href="Login.jsp"><i class=""></i>Log Out</a>
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Add Customer's  Device</h1>
                        <p align="center">
                        
                    </div>

                    <!-- /.col-lg-12 -->
                </div>
    
         <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Device Registration
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    
                                    <form role="form" action="AddDevice?custIC=<% out.print(request.getParameter("custIC")); %>" method="post">
                                        <div class="form-group">
                                            <label>Brand</label>
                                            <input type="text" class="form-control" name="Brand" placeholder="" required="required" autofocus="autofocus">
                                        </div>
                                        <div class="form-group">
                                            <label>Model</label>
                                            <input type="text" class="form-control" name="Model" placeholder="" required="required" autofocus="autofocus">
                                        </div>
                                        <div class="form-group">
                                            <label>Color</label>
                                            <input type="text" class="form-control" name="Color" placeholder="" required="required" autofocus="autofocus">
                                        </div>
                                        <div class="form-group">
                                            <label>Service Type</label><br>
                                            <input type="checkbox" class="" name="Format" value="format" placeholder=""   autofocus="autofocus">Format (RM30)
                                            <input type="hidden" name="Format" value="" checked="true"/><br>
                                            <input type="checkbox" class="" name="Install" value="installsoftware" placeholder=""  autofocus="autofocus">Install Software (RM30)
                                            <input type="hidden" name="Install" value="" checked="true"/><br>
                                            <input type="checkbox" class="" name="Repair" value="repair" placeholder=""   autofocus="autofocus">Repair (RM50)
                                            <input type="hidden" name="Repair" value="" checked="true"/><br>
                                        </div>
                                        <div class="form-group">
                                            <label>Date Submit</label>
                                            <input type="Date" class="form-control" name="Date" placeholder="" required="required" autofocus="autofocus">
                                        </div>
                                         <div class="form-group">
                                            <label>Problem Details</label>
                                            <input type="text" class="form-control"  name="ProblemDetails" placeholder="" required="required" autofocus="autofocus">
                                        </div>
                                        
                                         <div class="form-group">
                                            <label>Spare Part</label><br>
                                            <input type="checkbox" class="" name="Screen" value="screen" placeholder=""  autofocus="autofocus">Screen(RM70)
                                            <input type="hidden" name="Screen" value="" checked="true"/><br>
                                            <input type="checkbox" class="" name="HomeButton" value="homebutton" placeholder=""  autofocus="autofocus">Button (RM60)
                                            <input type="hidden" name="HomeButton" value="" checked="true"/><br>
                                            <input type="checkbox" class="" name="ChargingPort" value="chargingport" placeholder=""  autofocus="autofocus">Charging Port (RM70)
                                            <input type="hidden" name="ChargingPort" value="" checked="true"/><br>
                                            <input type="checkbox" class="" name="Battery" value="battery" placeholder=""  autofocus="autofocus">Battery (RM75)
                                            <input type="hidden" name="Battery" value="" checked="true"/><br>
                                        </div>
                                        
                                        <button type="submit" class="btn btn-primary">CREATE</button>
                                        <button type="reset" class="btn btn-danger">RESET</button>
                                    </form>
                                
                                <!-- /.col-lg-6 (nested) -->
                            </div>
          </div>

        </div>
        <!-- /.container-fluid -->
        </div>
        <!-- /.container-fluid -->
      </div>
                    <!-- /.panel -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>
    
    <!-- DataTables JavaScript -->
    <script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
