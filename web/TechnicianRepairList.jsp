<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

    <!-- DataTables CSS -->
    <link href="vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

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
                <a class="navbar-brand" href="">TurboFix E-Repair</a>
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
                            <a href="TechnicianHome.jsp"><i class=""></i> Home</a>
                        </li>
                        <li>
                            <a href="ViewAllRepairList?Status=tech"><i class=""></i>Repair Request List</a>
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

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Repair List</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="text-right">
                <%--<a href="AddDevice?custIC=<% out.print(request.getAttribute("ic")); %>"><button type="button" class="btn btn-primary">Add Device</button> </a> --%>
            </div>
            <br>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            List
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Device ID</th>
                                        <th>Repair ID</th>
                                        <th>Service Type</th>
                                        <th>Date Submit</th>
                                        <th>Problem Details</th>
                                        <th>Spare Part</th>
                                        <th>Price</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                   <%
                                    
                                    List<Device> dv = (ArrayList<Device>)request.getAttribute("device");
                                    List<ServiceRepair> sr = (ArrayList<ServiceRepair>)request.getAttribute("service");
                                    List<Status> st = (ArrayList<Status>)request.getAttribute("status");
                                    List<Sparepart> sp = (ArrayList<Sparepart>)request.getAttribute("sparepart");
                                    
                                    String status = "";
                                    String sparepart = "";
                                    for(Device d: dv)
                                    {
                                        for(ServiceRepair r: sr)
                                        {
                                            if(d.getDevice_ID() == r.getDeviceID())
                                            {
                                                for(Status t: st)
                                                {
                                                    for(Sparepart p: sp)
                                                    {
                                                        if(Integer.parseInt(r.getRepair_ID()) == p.getRepair_id())
                                                        {
                                                            sparepart = p.getSparepartname();
                                                        }
                                                    }

                                                    if(Integer.parseInt(r.getRepair_ID()) == t.getRepair_ID())
                                                    {
                                                        status = t.getServiceStatus();

                                                        out.print("<tr>");
                                                        out.print("<td>"+r.getDeviceID()+"</td>");
                                                        out.print("<td>"+r.getRepair_ID()+"</td>");
                                                        out.print("<td>"+r.getServiceType()+"</td>");
                                                        out.print("<td>"+r.getDateSubmit()+"</td>");
                                                        out.print("<td>"+r.getProblemDetails()+"</td>");
                                                        out.print("<td>"+sparepart+"</td>");
                                                        out.print("<td>"+r.getServiceRepairPrice()+"</td>");
                                                        out.print("<td>"+status+"</td>");
                                                        out.print("<td><a href='UpdateStatus?repairID="+r.getRepair_ID()+"'><div class='text-center'><button type='button' class='btn btn-primary' data-toggle='modal' data-target='#exampleModal'>Update</button></a></td>");
                                                        out.print("</tr>");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                   %>
                                </tbody>
                            </table>
                            <br>
                            <br>
                            <br>
                            <!-- /.table-responsive -->
                            
                        </div>

                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
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

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>
