<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        table, th, td {
          border: 1px solid black;
        }
        th{
            font-size: 30px;
        }
        td{
            font-size: 20px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Type</th>
            <th>Location</th>
        </tr>
        <#list items as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.title}</td>
                <td>${item.author}</td>
                <td>${item.type}</td>
                <td><a href="#">${item.location}</a></td>
            </tr>
        </#list>
	</table>
</body>
</html>
