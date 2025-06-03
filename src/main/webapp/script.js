function validateForm() {
  const password = document.getElementById("password").value;
  const confirm = document.getElementById("confirm").value;

  if (password !== confirm) {
    alert("Passwords do not match.");
    return false;
  }

  alert("Registration successful!");
  return true;
}

  history.pushState(null, "", location.href);
  window.onpopstate = function () {
    history.pushState(null, "", location.href);
  };
