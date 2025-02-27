//URL_BASE= "http://localhost:8080/api/productos/";
URL_BASE= "/api/productos/";


const contenedorProductos = document.getElementById("product_container");
const buttonaddon2 = document.getElementById("buttonaddon2");
const searchInput = document.getElementById("searchInput"); // Input con el id del HTML
const clearButton = document.getElementById("clearButton");

function addItem(item) {
    const elementoHTML =
        '<div class="card card_producto" style="width: 384px;">' +
        '    <figure class="card_img_wrapper shadow">' +
        '        <img src="' + item.imagen + '" class="card_img" alt="imagen del producto">' +
        '    </figure>' +
        '    <div class="card-body">' +
        '        <p class="product_name">' + item.nombre + '</p>' +
        '        <p class="product_description">' + item.descripcion + '</p>' +
        '        <p class="product_price">' + '$' + item.precio + '</p>' +
        '        <div class="product_rating">' +
        '            <span class="star">&#9733;</span>' +
        '            <span class="star">&#9733;</span>' +
        '            <span class="star">&#9733;</span>' +
        '            <span class="star">&#9733;</span>' +
        '            <span class="star">&#9734;</span>' + // Estrella vacía
        '        </div>' +
        '        <div class="button_content">' +
        '           <button class="product_button" type="button" onclick="agregarAlCarrito(' + item.id + ', \'' + item.nombre + '\', ' + item.precio + ', \'' + item.imagen + '\')">Agregar al carrito</button>' +
        '        </div>' +
        '    </div>' +
        '</div>';
    contenedorProductos.insertAdjacentHTML('beforeend', elementoHTML);
}


function mostrarProductos() {
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch(URL_BASE, requestOptions)
        .then((response) => response.json())
        .then((itemsFromBD) => {
            //console.log(itemsFromBD);
            items = [...items, ...itemsFromBD]; // Concatena los productos del localStorage al array 'items'
            // Agrega cada producto almacenado al contenedor
            itemsFromBD.forEach(item => addItem(item));
        })
        .catch((error) => console.error("Error al obtener los productos:", error));
}



window.addEventListener("load", function () {
    mostrarProductos();
});




let items = [
    // {
    //     'nombre': 'Mouse Gamer Logitech Óptico',
    //     'descripcion': 'Mouse ergonómico con sensor óptico avanzado, diseñado para gamers que buscan precisión y comodidad en largas sesiones de juego. Compatible con PC y Mac.',
    //     'imagen': 'https://www.cyberpuerta.mx/img/product/XL/CP-LOGITECH-910-006137-b23958.jpg',
    //     'precio': 1599.99,
    //     'categoria': 'periféricos'
    // },
    // {
    //     'nombre': 'Logitech Teclado Gamer G Pro',
    //     'descripcion': 'Teclado mecánico compacto con switches de alta precisión. Incluye iluminación RGB personalizable y diseño portátil ideal para torneos.',
    //     'imagen': 'https://www.cyberpuerta.mx/img/product/XL/CP-LOGITECH-920-009388-2.jpg',
    //     'precio': 2800.00,
    //     'categoria': 'periféricos'
    // },
    // {
    //     'nombre': 'Monitor Gamer ASUS TUF Gaming VG27AQL1A',
    //     'descripcion': 'Monitor de 27 pulgadas con resolución QHD, 170Hz de refresco y tecnología G-SYNC para una experiencia de juego fluida y sin interrupciones.',
    //     'imagen': 'https://www.cyberpuerta.mx/img/product/XL/CP-AOC-24G4E-9c171e.png',
    //     'precio': 7499.00,
    //     'categoria': 'periféricos'
    // },
    // {
    //     'nombre': 'Tarjeta Gráfica NVIDIA GeForce RTX 3060',
    //     'descripcion': 'Gráfica de alto rendimiento con tecnología de trazado de rayos en tiempo real y memoria GDDR6 de 12GB, perfecta para gaming y creación de contenido.',
    //     'imagen': 'https://www.cyberpuerta.mx/img/product/XL/CP-ASUS-90YV06N2-M0NA00-2.jpg',
    //     'precio': 10299.99,
    //     'categoria': 'componentes'
    // },
    // {
    //     'nombre': 'Procesador Intel Core i7-12700K',
    //     'descripcion': 'Procesador de 12 núcleos y 20 hilos con velocidades de hasta 5.0 GHz, ideal para gaming, productividad y multitarea intensiva.',
    //     'imagen': 'https://m.media-amazon.com/images/I/51AqEkc2BuL.__AC_SX300_SY300_QL70_ML2_.jpg',
    //     'precio': 8899.00,
    //     'categoria': 'componentes'
    // },
    // {
    //     'nombre': 'SSD Kingston NV1 1TB M.2 NVMe',
    //     'descripcion': 'Unidad de almacenamiento ultrarrápida con interfaz NVMe. Ofrece velocidades de lectura y escritura ideales para gaming y trabajo profesional.',
    //     'imagen': 'https://http2.mlstatic.com/D_NQ_NP_886276-MLA79769239420_102024-O.webp',
    //     'precio': 1349.00,
    //     'categoria': 'componentes'
    // },
    // {
    //     'nombre': 'Memoria RAM Corsair Vengeance LPX 16GB (2x8GB) DDR4',
    //     'descripcion': 'Kit de memoria RAM DDR4 de alto rendimiento con disipador de calor de perfil bajo. Ideal para overclocking y compatibilidad con sistemas compactos.',
    //     'imagen': 'https://m.media-amazon.com/images/I/61wCOVcyvFL._AC_SY450_.jpg',
    //     'precio': 1599.00,
    //     'categoria': 'componentes'
    // },
    // {
    //     'nombre': 'Fuente de Poder EVGA 600W 80 Plus White',
    //     'descripcion': 'Fuente de poder confiable con certificación 80 Plus White, que garantiza eficiencia energética y protección para tu sistema.',
    //     'imagen': 'https://m.media-amazon.com/images/I/61JIZLFj3eL._AC_SY450_.jpg',
    //     'precio': 899.00,
    //     'categoria': 'componentes'
    // },
    // {
    //     'nombre': 'Gabinete Gamer NZXT H510',
    //     'descripcion': 'Gabinete compacto con diseño minimalista, panel lateral de vidrio templado y excelente gestión de cables para un montaje limpio.',
    //     'imagen': 'https://m.media-amazon.com/images/I/71eyFRpHS3L._AC_SY450_.jpg',
    //     'precio': 1799.00,
    //     'categoria': 'ensambladas'
    // },
    // {
    //     'nombre': 'Audífonos Gamer HyperX Cloud II',
    //     'descripcion': 'Audífonos de alta fidelidad con sonido envolvente 7.1, almohadillas de espuma viscoelástica y micrófono desmontable para comunicación clara.',
    //     'imagen': 'https://m.media-amazon.com/images/I/71pz2njkNRL.__AC_SX300_SY300_QL70_ML2_.jpg',
    //     'precio': 1899.00,
    //     'categoria': 'periféricos'
    // }
];
//localStorage.setItem("items", JSON.stringify(items));

items.forEach(item => {
    addItem(item);
});

///////////////////////Buscador///////////////////////////////
function displayItems(items) {
    contenedorProductos.innerHTML = ""; // Limpia el contenedor
    items.forEach(item => addItem(item)); // Añade los elementos filtrados
}

function buscarProd() {
    const query = searchInput.value.toLowerCase().trim(); // Obtiene el valor del input en minúsculas
    const filteredItems = items.filter(item =>
        item.nombre.toLowerCase().includes(query) || // Filtra por nombre
        item.descripcion.toLowerCase().includes(query) // Filtra por descripción
    );

    // Muestra los productos filtrados o un mensaje si no se encontraron productos
    if (filteredItems.length === 0) {
        contenedorProductos.innerHTML = '<div class="no-products-message" style="display: flex; justify-content: center; align-items: center; height: 100vh;"><p>No se encontraron productos que coincidan con la búsqueda.</p></div>';
    } else {
        displayItems(filteredItems); // Muestra los productos filtrados
    }
}

buttonaddon2.addEventListener("click", function () {
    buscarProd();
});


searchInput.addEventListener("input", function () {
    const query = searchInput.value.toLowerCase().trim();
    if (query === "") {
        // Si el campo está vacío, muestra todos los productos
        displayItems(items);
    } else {
        buscarProd();
    }
});

clearButton.addEventListener("click", function () {
    searchInput.value = ""; // Limpia el contenido del input
    displayItems(items); // Muestra todos los productos
});




// Añadir el evento para el filtrado por categoría
document.querySelectorAll(".dropdown-item").forEach(item => {
    item.addEventListener("click", function () {
        const categoriaSeleccionada = this.getAttribute("data-filter").toLowerCase().trim(); // Obtiene la categoría seleccionada en minúsculas

        // Mostrar el toast con la categoría seleccionada
        const toastMensaje = document.getElementById("toastMensajeCat");
        const toastCategoria = new bootstrap.Toast(document.getElementById("toastCategoria"));

        toastMensaje.textContent = `Categoría seleccionada: ${this.textContent}`;
        toastCategoria.show();

        // Si la opción seleccionada es "todos", mostramos todos los productos
        if (categoriaSeleccionada === "todos") {
            displayItems(items);
            return;
        }

        // Filtra los productos por la categoría seleccionada
        const filteredItems = items.filter(item =>
            item.categoria.toLowerCase().includes(categoriaSeleccionada)
        );

        // Muestra los productos filtrados o un mensaje si no se encontraron productos
        if (filteredItems.length === 0) {
            contenedorProductos.innerHTML = `
                <div class="no-products-message" style="display: flex; justify-content: center; align-items: center; height: 100vh;">
                    <p>No se encontraron productos en esta categoría.</p>
                </div>`;
        } else {
            displayItems(filteredItems);
        }
    });
});



function actualizarContadorCarrito() {
    let carrito = JSON.parse(localStorage.getItem("carrito")) || []; // Cargar el carrito desde el almacenamiento local
    let totalCantidad = carrito.reduce((total, item) => total + item.cantidad, 0); // Sumar las cantidades de los productos

    const contadorCarrito = document.getElementById("contadorCarrito");

    if (contadorCarrito) {
        contadorCarrito.style.color = "white"; 

        if (totalCantidad > 0) {
            contadorCarrito.textContent = totalCantidad; // Actualizar el contador con la cantidad total
        } else {
            contadorCarrito.textContent = 0; // Mostrar 0 si no hay productos
        }
    }
}



function agregarAlCarrito(id, nombre, precio, imagen) {
    let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

    // Verificar si el producto ya está en el carrito
    let productoExistente = carrito.find(item => item.id === id);

    if (productoExistente) {
        productoExistente.cantidad += 1; // Aumenta la cantidad
    } else {
        carrito.push({ id, nombre, precio, imagen, cantidad: 1 });
    }

    localStorage.setItem("carrito", JSON.stringify(carrito));
    actualizarContadorCarrito(); 
    // Mostrar toast con el producto agregado
    mostrarToast(nombre, imagen);
}



function mostrarToast(nombre, imagen) {
    const toastMensaje = document.getElementById("toastMensaje");
    const toastImagen = document.getElementById("toastImagen");
    const toastCarrito = new bootstrap.Toast(document.getElementById("toastCarrito"));

    toastMensaje.textContent = `Agregado al carrito: ${nombre}`;
    toastImagen.src = imagen;

    toastCarrito.show();
}
