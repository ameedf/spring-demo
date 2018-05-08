const app = {
	events: [],
	baseURL: 'rest/api/event'
};

function showAllEvents() {
	const request = new XMLHttpRequest();
	request.onreadystatechange = function () {
		if (this.readyState === 4 && this.status === 200) {
			log("All events: " + this.responseText);
			app.events = JSON.parse(this.responseText);
			createTable();
		}
	};
	request.open("GET", app.baseURL + "/all", true);
	request.send();
}

function createTable() {
	if (app.events.length === 0) {
		element("eventsGrid").innerHTML = "<h1>No events found !!</h1>";
		return;
	}
	let t = "<table>";
	t += "<tr>";
	t += "<th>Description</th>";
	t += "<th>Start date</th>";
	t += "<th></th>";
	t += "</tr>";
	for (let i = 0; i < app.events.length; i++) {
		const event = app.events[i];
		t += "<tr>";
		t += "<td>" + event.description + "</td>";
		t += "<td>" + event.startDate + "</td>";
		t += "<td onclick='removeEvent(" + event.id + ")' class='remove'>x</td>";
		t += "</tr>";
	}
	t += "</table>";
	element("eventsGrid").innerHTML = t;
}

function removeEvent(eventId) {
	const request = new XMLHttpRequest();
	request.onreadystatechange = function () {
		if (this.readyState === 4 && this.status === 200) {
			log("Deleted event: " + this.responseText);
			showAllEvents();
		}
	};
	request.open("DELETE", app.baseURL + "/" + eventId, true);
	request.send();

}

function addEvent() {
	hide(element('addEventBtn'));

	const event = {
		description: element("description").value,
		startDate: element("startDate").value
	};

	if (event.description == null || event.description.length === 0
		|| event.startDate == null || event.startDate.length === 0) {
		alert("Please fill all the fileds");
		show(element('addEventBtn'));
		return;
	}

	const xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		if (this.readyState === 4 && this.status === 200) {
			log("new id is " + this.responseText);
			showAllEvents();
		}
	};
	xhttp.open("POST", app.baseURL, true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(JSON.stringify(event));
	show(element('addEventBtn'));
}

function hide(element) {
	element.style.visibility = 'hidden';
}

function show(element) {
	element.style.visibility = '';
}

function element(elementId) {
	return document.getElementById(elementId);
}

function log(item) {
	console.log(item);
}