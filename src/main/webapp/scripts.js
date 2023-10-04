(()=>{
    const tbody = document.getElementById("tBody")

    const xhr = new XMLHttpRequest()

    xhr.open("GET","servlet-subject",true )

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            const subjects = JSON.parse( xhr.responseText )
            subjects.forEach( subject => {
                const row = document.createElement("tr")

                const colId = document.createElement("td")
                colId.appendChild( document.createTextNode( subject.id ) );
                row.appendChild( colId )

                const colName = document.createElement("td")
                colName.appendChild( document.createTextNode(subject.name))
                row.appendChild( colName )

                tbody.appendChild(row)
            })
        }
    }

    xhr.send()
})()

document.getElementById('btnSend').addEventListener('click',()=>{
    const idSubject = document.getElementById('idSubject').value
    const name = document.getElementById('name').value

    const xhr = new XMLHttpRequest()

    xhr.open("POST","add-subject",true)

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            if( xhr.responseText ){
                const subject = JSON.parse(xhr.responseText)
                alert("La asignatura se inserto satisfactoriamente")

                const tbody = document.getElementById('tBody')
                const row = document.createElement("tr")

                const colId = document.createElement("td")
                colId.appendChild(document.createTextNode(subject.id))
                row.appendChild( colId)

                const colName= document.createElement("td")
                colName.appendChild(document.createTextNode(subject.name))
                row.appendChild( colName)

                tbody.appendChild(row)
            }else{
                alert("No fue posible Insertar el Registro")
            }
        }
    }
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    const data = `name=${name}&idSubject=${idSubject}`
    xhr.send(data)
})