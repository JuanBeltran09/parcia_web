function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}
(()=>{
    const tbody = document.getElementById("tBody")

    const xhr = new XMLHttpRequest()

    xhr.open("GET","../servlet-activity",true )

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            const subjects = JSON.parse( xhr.responseText )
            subjects.forEach( subject => {

                var id = parseInt(getUrlParameter('id'));

                var sid = parseInt(subject.id);

                console.log(id)
                console.log(subject.id)
                if(sid === id ){
                    const row = document.createElement("tr")

                    const colName = document.createElement("td")
                    const link =document.createElement("a")

                    link.appendChild(document.createTextNode(subject.name))

                    const subjectJson = JSON.stringify(subject);
                    const encodedSubjectJson = encodeURIComponent(subjectJson);
                    const url = `../sites/activityDesc.jsp?subjectData=${encodedSubjectJson}`;

                    link.href = url;
                    colName.appendChild( link)
                    row.appendChild( colName )

                    tbody.appendChild(row)
                }

            })
        }
    }

    xhr.send()
})()