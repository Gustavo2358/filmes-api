const formE1 = document.querySelector('.form')

formE1.addEventListener('submit', event => {
    event.preventDefault()
    
    const formData = new FormData(formE1)
    const data = Object.fromEntries(formData)
    console.log(data)
    
    const atores = Array.from(document.querySelectorAll('#atores1, #atores2, #atores3'))
                    .map(ator => ator.value)

    data.atores = atores
    console.log(JSON.stringify(data))
    
    fetch('http://localhost:8080/filmes', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json',
        },
        body: JSON.stringify(data)
    }).then(res => res.json())
      .then(data => console.log(data))
      .catch(error => console.log(error))
})