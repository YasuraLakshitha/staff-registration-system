
loadCategory();
const btnSubmit = document.getElementById('btn-submit');
const toastLive = document.getElementById('liveToast');
const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLive);

function loadCategory() {
    fetch("http://localhost:8080/category").then(response => response.json()).then(data => {
        data.forEach(element => {
            let area = document.createElement('option');
            let specializationArea = document.getElementById('specialization-area');
            area.value = element.description;
            area.textContent = element.description;
            specializationArea.append(area);
        });
    })
}

function saveMember() {
    let requestBody = {
        firstName: document.getElementById("first-name").value,
        lastName: document.getElementById("last-name").value,
        idNumber: document.getElementById("nic-number").value,
        email: document.getElementById("email").value,
        address: document.getElementById("address").value,
        dateOfBirth: document.getElementById("date-of-birth").value,
        contactNumber: document.getElementById("contact-number").value,
        spacializationArea: document.getElementById("specialization-area").value,
        isActive: true
    }

    fetch("http://localhost:8080/member",
        {
            method: "POST",
            body: JSON.stringify(requestBody),
            headers: {
                "content-type": "application/json"
            }
        }
    ).then().then(() => {
        toastBootstrap.show();
    }).catch(err => console.log(err))
}

function validateInputs() {

    const forms= document.querySelectorAll('.needs-validation')
    Array.from(forms).forEach(form => addEventListener('submit', event => {
        event.preventDefault();
        event.stopPropagation();
        if (form.checkValidity())
            saveMember();
        form.classList.add('was-validated');
    },false)
    )
}

