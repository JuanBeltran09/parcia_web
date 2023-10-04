(()=>{
    const tbody = document.getElementById("tBody")

    const xhr = new XMLHttpRequest()

    xhr.open("GET","../servlet-subject",true )

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            const subjects = JSON.parse( xhr.responseText )
            subjects.forEach( subject => {
                const row = document.createElement("tr")

                const colName = document.createElement("td")
                colName.appendChild( document.createTextNode(subject.name))
                row.appendChild( colName )

                tbody.appendChild(row)
            })
        }
    }

    xhr.send()
})()