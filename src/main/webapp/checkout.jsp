<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css?v=2" type="text/css"/>
</head>
<body>
<h1>
Checkout
</h1>
<table>
<thead>
    <tr>
        <th>Quantity</th>
        <th class = "right">Description</th>
        <th class = "right"> Price </th>
        <th class = "right">Amount </th>
    </tr>
</thead>
<tbody>
    <c:forEach
     items="${cart.items}"
     var="item"
     >
        <tr>
            <td>
           ${item.quantity}
           </td>
           <td>
                ${item.product.description}
           </td>
           <td class = "right">
                ${item.product.priceCurrencyFormat}
           </td>
           <td class = "right">
           ${item.totalCurrencyFormat}
           </td>
        </tr>
     </c:forEach>

</tbody>
<tfoot>
<tr>
<td>
${cart.totalQuantity}
</td>
<td>
Total
</td>
<td></td>
<td class = "right">
${cart.totalCurrencyFormat}
</td>
</tr>
</tfoot>
</table>
<form action = "cart" method = "post" class="bottom-btn">
    <input type="hidden" name="action" value="cart">
    <input type="submit" value="Back to Cart">
</form>

<form action="cart" method="post" class="bottom-btn">
        <input type="hidden" name="action" value="complete">
        <input type="submit" value="Confirm Order">
</form>


</body>
</html>