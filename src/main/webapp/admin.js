function showSection(id) {
  const sections = document.querySelectorAll('.section');
  sections.forEach(section => {
    section.style.display = (section.id === id) ? 'block' : 'none';
  });
}

function logout() {
  // You can redirect or clear session here
  alert("Logging out...");
  window.location.href = "index.html";
}
