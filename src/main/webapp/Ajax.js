/**
 * 
 */

function myAJAX() {
			let newRequest = new XMLHttpRequest();
			newRequest.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("reply").innerHTML = this.responseText;
				}
			};
			newRequest
					.open(
							"GET",
							"https://gist.githubusercontent.com/signed0/d70780518341e1396e11/raw/2a7f4af8d181a714f9d49105ed57fafb3f450960/quotes.json",
							true);
			newRequest.send();
//			document.getElementById("image").src = "https://graphics8.nytimes.com/images/2013/05/21/technology/21-baby/21-baby-custom1.gif";

		}
		//document.getElementById("image").innerHTML.src = "https://i.gifer.com/OWS5.gif"