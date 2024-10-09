document.getElementById('hamburger').addEventListener('click' , function() {
    const nav = document.getElementById('nav');
    const authLinks = document.getElementById('auth-links');
    nav.classList.toggle('show-menu');
    authLinks.classList.toggle('show-menu');
})