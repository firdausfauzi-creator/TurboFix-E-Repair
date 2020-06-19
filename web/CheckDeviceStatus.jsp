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

       

        
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center">
                        <a href="CheckDeviceStatus.jsp">
                        <img src="img/Header.jpeg" height= 200px widht=200px><br><br>
                        </a>
                        TRACE YOUR DEVICE STATUS HERE
                    </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
           
        <form action="CheckDevice" method="get">    
            <div class="input-group custom-search-form" style="width: 30%; text-align: center; margin-left: 540px">
                
                <input type="text" name="custIC" class="form-control" required placeholder="Enter Your IC Number">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
                        </span>
               
            </div> 
        </form>
            <br>
                            
                            
            <div class="row">
                <div class="col-lg-12">
                    <%
                        if(request.getAttribute("set")!=null)
                        {
                    %>
                    <div class="panel panel-red ">
                        <div class="panel-heading">
                            List
                            
                        </div>
                        <!-- /.panel-heading -->
                        
                        <div class="panel-body">
                        
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Device ID</th>
                                        <th>Device Model</th>
                                        <th>Repair ID</th>
                                        <th>Price (RM)</th>
                                        <th>Last Updated</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        
                                            List<Device> dv = (ArrayList<Device>)request.getAttribute("device");
                                            List<ServiceRepair> sr = (ArrayList<ServiceRepair>)request.getAttribute("service");
                                            List<Status> st = (ArrayList<Status>)request.getAttribute("status");
                                            int i = 0;
                                            for(Device dev: dv)
                                            {
                                                
                                                out.print("<tr>");
                                                out.print("<td>"+dev.getDevice_ID()+"</td>");
                                                out.print("<td>"+dev.getDeviceModel()+"</td>");
                                                out.print("<td>"+sr.get(i).getRepair_ID()+"</td>");
                                                out.print("<td>"+sr.get(i).getServiceRepairPrice()+"</td>");
                                                out.print("<td>"+st.get(i).getLastStatusUpdate()+"</td>");
                                                out.print("<td>"+st.get(i).getServiceStatus()+"</td>");
                                                out.print("</tr>");
                                                i++;
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
                            <%
                                }
                            %>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
       
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
