
document.getElementById('AddActivityBtn').addEventListener('click',()=>{
    const idSubject = document.getElementById('idSubject').value
    const name = document.getElementById('name').value

    const xhr = new XMLHttpRequest()

    xhr.open("POST","../add-activity",true)

    xhr.onreadystatechange = ()=>{
        if( xhr.readyState === 4 && xhr.status === 200 ){
            if( xhr.responseText ){
                const subject = JSON.parse(xhr.responseText)
                alert("La asignatura se inserto satisfactoriamente")
            }else{
                alert("No fue posible Insertar el Registro")
            }
        }
    }
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    const data = `name=${name}&idSubject=${idSubject}`
    xhr.send(data)
})