document.addEventListener('DOMContentLoaded', function () {
    var volverBtn = document.getElementById('volverBtn');

    volverBtn.addEventListener('click', function () {

        window.location.href = 'activityList.jsp';
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
colName.appendChild(document.createTextNode(subject.id))
row.appendChild( colName )


tbody.appendChild(row)