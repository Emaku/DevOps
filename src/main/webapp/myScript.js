/**
 * 
 */

function addRecord() {

	var rt = document.getElementById("reasonTypeID");
	var r = document.getElementById("reasonID");
	var amount = document.getElementById("amountID");

	var table = document.getElementById("myTable");
	var row = table.insertRow(1);
	var rtCell = row.insertCell(0);
	var rCell = row.insertCell(1);
	var statusCell = row.insertCell(2);
	var arqCell = row.insertCell(3);
	var arCell = row.insertCell(4);
	var apbCell = row.insertCell(5);

	rtCell.innerHTML = rt.value;
	rCell.innerHTML = r.value;
	statusCell.innerHTML = "Pending...";
	arqCell.innerHTML = amount.value;
	arCell.innerHTML = "0.00";
	apbCell.innerHTML = "Awaiting";

}

function viewReimbursement() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			var text;
			for (var i = 0; i < json.Reimbursements.length; i++) {

				if (json.Reimbursements[i].Status != "Pending") {
					console.log(json.Reimbursements[i]);
					text += "" + JSON.stringify(json.Reimbursements[i]) + "\n";
				}
			}

			console.log(text);
			// obj = JSON.stringify(json.Reimbursements[i].Status);
			para.innerHTML = text;

		}

	}
	xhr.send();

}

function viewPending() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			var text;
			for (var i = 0; i < json.Reimbursements.length; i++) {

				if (json.Reimbursements[i].Status == "Pending") {
					console.log(json.Reimbursements[i]);
					text += "" + JSON.stringify(json.Reimbursements[i]) + "\n";
				}
			}

			console.log(text);
			// obj = JSON.stringify(json.Reimbursements[i].Status);
			para.innerHTML = text;

		}

	}
	xhr.send();

}

function viewResolved() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			var text;
			for (var i = 0; i < json.Reimbursements.length; i++) {

				if (json.Reimbursements[i].Status != "Pending") {
					console.log(json.Reimbursements[i]);
					text += "" + JSON.stringify(json.Reimbursements[i])
							+ "<br>";
				}
			}

			console.log(text);
			// obj = JSON.stringify(json.Reimbursements[i].Status);
			para.innerHTML = text;

		}

	}
	xhr.send();

}

function viewMemberRmb() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			var text;
			for (var i = 0; i < json.Reimbursements.length; i++) {

				if (json.Reimbursements[i].Mid == document
						.getElementById("enterMID").value) {
					// text += "" + json.Reimbursements[i]
					console.log(i);
					obj = "" + JSON.stringify(json.Reimbursements[i]);
				}
			}

			// console.log(obj);
			// obj = JSON.stringify(json.Reimbursements[i]);
			para.innerHTML = obj;

		}

	}
	xhr.send();

}

function myPendings() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			var text;
			for (var i = 0; i < json.Reimbursements.length; i++) {

				if (json.Reimbursements[i].Mid == json.CurrentUser.CurrentMid
						&& json.Reimbursements[i].Status == "Pending") {
					console.log(i);
					console.log(json.CurrentUser.CurrentMid);
					// text += "" + json.Reimbursements[i]
					console.log(json.Reimbursements[i]);
					obj = JSON.stringify(json.Reimbursements[i]);
				}
			}

			// console.log(obj);
			// obj = JSON.stringify(json.Reimbursements[i]);
			para.innerHTML = obj;

		}

	}
	xhr.send();

}

function myResolved() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			var text;
			for (var i = 0; i < json.Reimbursements.length; i++) {

				if (json.Reimbursements[i].Mid == json.CurrentUser.CurrentMid
						&& json.Reimbursements[i].Status != "Pending") {
					console.log(i);
					// text += "" + json.Reimbursements[i]
					console.log(json.Reimbursements[i]);
					obj = JSON.stringify(json.Reimbursements[i]);
				}
			}

			// console.log(obj);
			// obj = JSON.stringify(json.Reimbursements[i]);
			para.innerHTML = obj;

		}

	}
	xhr.send();

}

function viewMyInfo() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			var text;
			for (var i = 0; i < json.Members.length; i++) {

				if (json.Members[i].id == json.CurrentUser.CurrentMid) {

					// text += "" + json.Reimbursements[i]
					console.log(json.Members[i]);
					obj = JSON.stringify(json.Members[i]);
				}
			}

			// console.log(obj);
			// obj = JSON.stringify(json.Reimbursements[i]);
			para.innerHTML = obj;

		}

	}
	xhr.send();

}

function approve() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			var text;
			for (var i = 0; i < json.Reimbursements.length; i++) {

				if (json.Reimbursements[i].rid == document
						.getElementById("enterRID").value) {
					console.log(json.Reimbursements[i]);
					obj = JSON.stringify(json.Reimbursements[i]);
				}
			}

			console.log(text);
			// obj = JSON.stringify(json.Reimbursements[i].Status);
			para.innerHTML = text;

		}

	}
	xhr.send();

}

//function rmbSubmit() {
//	console.log("Hello World");
//	var obj;
//	var text, mid;
//	var xhr = new XMLHttpRequest();
//	xhr.open('Get', 'http://localhost:8080/HomeProject/MyServlet.json', true);
//	var reasonType = document.getElementById("reasonTypeID").value;
//	var reason = document.getElementById("reasonID").value;
//	var amount = document.getElementById("amountID").value;
//
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState == 4 && xhr.status == 200) {
//			obj = xhr.responseText;
//			json = JSON.parse(obj);
//			var para = document.getElementById("printHere");
//			// console.log(json.Members);
//
//			
//			obj = json.CurrentUser.CurrentMid;
//
////			for (var i = 0; i < json.Members.length; i++) {
////
////				// text += "" + json.Reimbursements[i]
//////				console.log(json.Members[i]);
//////				obj = JSON.stringify(json.Members[i]);
////			}
//		}
//
////		console.log(text);
//		// obj = JSON.stringify(json.Reimbursements[i].Status);
//		para.innerHTML = obj;
//
//	}
//
//	xhr.send("mid="+mid+"reasonType="+reasonType+"reason="+reason+"amount="+amount);
//
//}

// console.log("Hello World");
// var obj, record, parentElement;
// var xhr = new XMLHttpRequest();
// xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
// xhr.onreadystatechange = function() {
// if (xhr.readyState == 4 && xhr.status == 200) {
// var obj = xhr.responseText;
// json = JSON.parse(obj);
// var para = document.getElementById("printHere");
// console.log(json.CurrentUser);
//		
// obj = JSON.stringify(json.CurrentUser.CurrentMid);
// para.innerHTML = obj;
//
// }
//
// }
// xhr.send();

function viewAllEmp() {
	console.log("Hello World");
	var obj;
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			console.log(json.Members);

			obj = JSON.stringify(json.Members);
			para.innerHTML = obj;

		}

	}
	xhr.send();

}

function rmbSubmit() {
	console.log("Hello World");
	var obj;
	var text, mid;
	var xhr = new XMLHttpRequest();
	xhr.open('Get', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	var reason = document.getElementById("reasonID").value;
	var amount = document.getElementById("amountID").value;

	console.log(document.url);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			
			obj = json.CurrentUser.CurrentMid;

//			for (var i = 0; i < json.Members.length; i++) {
//
//				// text += "" + json.Reimbursements[i]
////				console.log(json.Members[i]);
////				obj = JSON.stringify(json.Members[i]);
//			}
		}

//		console.log(text);
		// obj = JSON.stringify(json.Reimbursements[i].Status);
		para.innerHTML = "mid="+mid+"reason="+reason+"amount="+amount;
		text = "http://localhost:8080/HomeProject/EmployeeHome.html" + "?mid="+mid+"-reason="+reason+"-amount="+amount;
		window.location.href = text;
		
		

	}

//	xhr.send("mid="+mid+"&reasonType="+reasonType+"&reason="+reason+"&amount="+amount);
	xhr.send();

}

function updateMem() {
	console.log("Hello World");
	var obj;
	var text, mid;
	var xhr = new XMLHttpRequest();
	xhr.open('Get', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	var username = document.getElementById("newUsername").value;
	var password = document.getElementById("newPassword").value;
	var email = document.getElementById("newEmail");

	console.log(document.url);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			
			obj = json.CurrentUser.CurrentMid;

//			for (var i = 0; i < json.Members.length; i++) {
//
//				// text += "" + json.Reimbursements[i]
////				console.log(json.Members[i]);
////				obj = JSON.stringify(json.Members[i]);
//			}
		}

//		console.log(text);
		// obj = JSON.stringify(json.Reimbursements[i].Status);
		para.innerHTML = "mid="+mid+"reason="+reason+"amount="+amount;
		text = "http://localhost:8080/HomeProject/EmployeeHome.html" + "?mid="+mid+"-reason="+reason+"-amount="+amount;
		window.location.href = text;
		
		

	}
	
}

function changeStatus() {
	console.log("Hello World");
	var obj;
	var text, mid;
	var xhr = new XMLHttpRequest();
	xhr.open('Get', 'http://localhost:8080/HomeProject/MyServlet.json', true);
	var username = document.getElementById("newUsername").value;
	var password = document.getElementById("newPassword").value;
	var email = document.getElementById("newEmail");

	console.log(document.url);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			obj = xhr.responseText;
			json = JSON.parse(obj);
			var para = document.getElementById("printHere");
			// console.log(json.Members);

			
			obj = json.CurrentUser.CurrentMid;

//			for (var i = 0; i < json.Members.length; i++) {
//
//				// text += "" + json.Reimbursements[i]
////				console.log(json.Members[i]);
////				obj = JSON.stringify(json.Members[i]);
//			}
		}

//		console.log(text);
		// obj = JSON.stringify(json.Reimbursements[i].Status);
		para.innerHTML = "mid="+mid+"reason="+reason+"amount="+amount;
		text = "http://localhost:8080/HomeProject/EmployeeHome.html" + "?mid="+mid+"-reason="+reason+"-amount="+amount;
		window.location.href = text;
		
		

	}
	
}

//function updateReimbursement() {
//    
//    var cookie = document.cookie;
//    var manager = document.getElementById("loggedInAs").innerHTML;
//    var reimbursementID = document.getElementById("reimbursementID").value;
//    var status = document.getElementById("statusID").value;
//    console.log(reimbursementID+ "  succesfully did function   "+ status)
//    
//    var xhttp = new XMLHttpRequest();
//      xhttp.onreadystatechange = function() {
//        if (this.readyState == 4 && this.status == 200) {
//            console.log("sent the info" + manager)
//        }
//      };
//      xhttp.open("POST", "/reimbursement/manager.do");
//    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//
//      xhttp.send("ID="+reimbursementID+"&status="+status+"&manager="+manager);
//    
//}



/*
 * function displayAllReimbursements(){ var xhr = new XMLHttpRequest();
 * 
 * xhr.onreadystatechange = function(){ if(xhr.readyState == 4 && xhr.status ==
 * 200){ var obj = JSON.parse(xhr.responseText); console.log(obj); } }
 * xhr.open('GET', 'http://localhost:8080/HomeProject/MyServlet.json', true);
 * xhr.send(); }
 */

