function f1(itemId) {
	var count = document.getElementById("cart-item-count").textContent;
	count = +count + 1;
	document.getElementById("cart-item-count").textContent = count;
	document.getElementById("inner-cart-item-count").textContent = count;
	var link = document.getElementById("cart").href;
	link = link + "itemId=" + itemId + "&";
	document.getElementById("cart").href = link;
	return false;
}
