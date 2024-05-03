var lastScrollTop = 0;

function handleScroll() {
    var currentScroll = window.pageYOffset || document.documentElement.scrollTop;
    var header = document.getElementById('main-header');

    if (currentScroll > lastScrollTop) {
        header.classList.add('hidden'); // Oculta el header al desplazar hacia abajo
    } else {
        header.classList.remove('hidden'); // Muestra el header al desplazar hacia arriba
    }

    lastScrollTop = currentScroll <= 0 ? 0 : currentScroll; // Reinicia el valor de lastScrollTop
}

function toggleNav() {
    var navList = document.getElementById('nav-list');
    if (navList.style.display === 'none' || navList.style.display === '') {
        navList.style.display = 'block'; // Muestra la lista de navegación si está oculta
    } else {
        navList.style.display = 'none'; // Oculta la lista de navegación si está visible
    }
}
