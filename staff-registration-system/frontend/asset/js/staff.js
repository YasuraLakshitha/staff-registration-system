const tlbMembers = document.getElementById("staff-members");
loadData();

let tabelData = `<th>Staff Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Date of birth</th>
                <th>Contact Number</th>
                <th>Specialization area</th>`;

function loadData() {
    fetch("http://localhost:8080/members").then(res => res.json()).then(data => {
        data.forEach(element => {
            tabelData += `<tr>
                            <td contentEditable = ${false}>${element.staffId}</td>
                            <td>${element.firstName}</td>
                            <td>${element.lastName}</td>
                            <td>${element.email}</td>
                            <td>${element.address}</td>
                            <td>${element.dateOfBirth}</td>
                            <td>${"+94 " + element.contactNumber}</td>
                            <td contentEditable = ${false}>${element.spacializationArea}</td>
                            <td>
                                <button class="btn btn-success" onclick="updateMember(${element.staffId})">Update</button>
                                <button class="btn btn-danger" onclick="removeMember(${element.staffId})">Remove</button>
                            </td>
                        <tr/>`;
            tlbMembers.innerHTML = tabelData;
        });
    });
}

function removeMember(id) {
    const btnModalWarning = document.getElementById('btn-warning');
    btnModalWarning.click();

    const btnRemove = document.getElementById('btn-remove');
    btnRemove.addEventListener('click', evt => {
        let requestBody = {
            staffId: id
        }

        fetch(`http://localhost:8080/member?id=${id}`,
            {
                method: "DELETE",
                body: JSON.stringify(requestBody),
                headers: {
                    "Content-type": "application/json"
                }
            }
        ).then().then(refreshPage).catch(err => console.log(err));

    })
}

function updateMember(id) {

    fetch(`http://localhost:8080/member?memberId=${id}`).then(members => members.json()).then(member => {

        document.getElementById('first-name').value = member.firstName;
        document.getElementById('last-name').value = member.lastName;
        document.getElementById('email').value = member.email;
        document.getElementById('nic-number').value = member.idNumber;
        document.getElementById('date-of-birth').value = member.dateOfBirth;
        document.getElementById('contact-number').value = member.contactNumber;
        document.getElementById('selected-area').innerHTML = member.spacializationArea;
        document.getElementById('address').value = member.address;

        const btnMemberDetailsModal = document.getElementById('modal-button');
        btnMemberDetailsModal.click();

        const btnSave = document.getElementById('btn-save');
        btnSave.addEventListener('click', event => {
            let requestBody = {
                staffId: id,
                firstName: document.getElementById('first-name').value,
                lastName: document.getElementById('last-name').value,
                idNumber: document.getElementById('nic-number').value,
                email: document.getElementById('email').value,
                address: document.getElementById('address').value,
                dateOfBirth: document.getElementById('date-of-birth').value,
                contactNumber: document.getElementById('contact-number').value,
                spacializationArea: document.getElementById('specialization-area').value,
                isActive: true
            }

            fetch(`http://localhost:8080/member`,
                {
                    method: "PATCH",
                    body: JSON.stringify(requestBody),
                    headers: {
                        "Content-type": "application/json"
                    }
                }
            ).then(res => res.json()).then(refreshPage);
        })
    })

};


function refreshPage() {
    const metaElement = document.getElementById('refresh-page');
    metaElement.innerHTML = `<meta http-equiv="refresh" content="0"></meta>`;
}