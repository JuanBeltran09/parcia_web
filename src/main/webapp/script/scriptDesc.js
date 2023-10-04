document.addEventListener('DOMContentLoaded', function () {
    var volverBtn = document.getElementById('volverBtn');

    volverBtn.addEventListener('click', function () {

        window.location.href = 'activityList.jsp?id='+subject.id;
    });
});

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const encodedSubjectJson = urlParams.get('subjectData');

const subjectJson = decodeURIComponent(encodedSubjectJson);

const subject = JSON.parse(subjectJson);

const tbody = document.getElementById("tBody")

const row = document.createElement("tr")

const colName = document.createElement("td")
colName.appendChild(document.createTextNode(subject.name))
row.appendChild( colName )

const colType = document.createElement("td")
colType.appendChild(document.createTextNode(subject.type))
row.appendChild( colType )

const colDate = document.createElement("td")
colDate.appendChild(document.createTextNode(subject.date))
row.appendChild( colDate )

const colPercentage = document.createElement("td")
colPercentage.appendChild(document.createTextNode(subject.percentage))
row.appendChild( colPercentage )

tbody.appendChild(row)