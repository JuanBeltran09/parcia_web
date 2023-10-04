
document.getElementById('AddActivityBtn').addEventListener('click',()=>{
    const id = document.getElementById('id').value
    const nombre = document.getElementById('nombre').value
    const tipo = document.getElementById('tipo').value
    const fechaInicio = document.getElementById('fechaInicio').value
    const ponderado = document.getElementById('ponderado').value

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
    const data = `nombre=${nombre}&id=${id}&tipo=${tipo}&fechaInicio=${fechaInicio}&ponderado=${ponderado}`
    xhr.send(data)
})