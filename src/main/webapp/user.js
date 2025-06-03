function showTab(id) {
  document.querySelectorAll('.tab').forEach(tab => {
    tab.classList.remove('active');
  });
  document.getElementById(id).classList.add('active');
}

document.getElementById("todayDate").textContent = new Date().toLocaleDateString();

const billTable = document.getElementById("billBody");

billTable.addEventListener("input", function () {
  updateBill();
});

billTable.addEventListener("keydown", function (e) {
  if (e.key === "Enter" && e.target.classList.contains("desc")) {
    e.preventDefault();
    const newRow = document.createElement("tr");
    newRow.innerHTML = `
      <td><input type="text" class="desc" placeholder="Item name" /></td>
      <td><input type="number" class="qty" placeholder="0" /></td>
      <td><input type="number" class="price" placeholder="0.00" /></td>
      <td><input type="number" class="amount" placeholder="0.00" readonly /></td>
    `;
    billTable.appendChild(newRow);
    newRow.querySelector(".desc").focus();
  }
});



function printBill() {
  window.print();
}

function logout() {
  window.location.href = "login.html"; // Redirect to login page
}
