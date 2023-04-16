import './App.css';
import React, { useState, useEffect } from 'react';
import CategoriesComponent from './components/inventory/CategoriesComponent';
import ProductsComponent from './components/inventory/ProductsComponent';
import ProductComponent from './components/inventory/ProductComponent';
import CartSummary from './components/shopping/CartSummary';
import CartDetail from './components/shopping/CartDetail';
import CartCheckout from './components/shopping/CartCheckout';
import axios from 'axios';

function App() {
  const [categories, setCategories] = useState([]);
  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState([]);
  const [cartProducts, setCartProducts] = useState([]);

  useEffect(() => {
    axios.get('/categories')
      .then(response => {
        setCategories(response.data);
      })
      .catch(error => {
        console.log(error);
      });

    axios.get('/cart/get/1')
      .then(response => {
        setCart(response.data);
        setCartProducts(response.data.cartProducts);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const getProductsByCategory = (categoryId) => {
    axios.get(`/products/${categoryId}`)
      .then(response => {
        setProducts(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }

  const addToCart = (productId) => {
    axios.post(`/cart/add/${cart.id}/${productId}`)
      .then(response => {
        setCart(response.data);
        setCartProducts(response.data.cartProducts);
      })
      .catch(error => {
        console.log(error);
      });
  }

  const removeFromCart = (productId) => {
    axios.post(`/cart/remove/${cart.id}/${productId}`)
      .then(response => {
        setCart(response.data);
        setCartProducts(response.data.cartProducts);
      })
      .catch(error => {
        console.log(error);
      });
  }

  const checkout = (customerName, cardNumber) => {
    axios.post('/cart/checkout', { cartId: cart.id, customerName: customerName, cardNumber: cardNumber })
      .then(response => {
        setCart(response.data);
        setCartProducts(response.data.cartProducts);
      })
      .catch(error => {
        console.log(error);
      });
  }

  return (
    <div className="App">
      <h1>Inventory</h1>
      <div className="inventory">
        <CategoriesComponent categories={categories} onSelectCategory={getProductsByCategory} />
        <ProductsComponent products={products} onAddToCart={addToCart} />
        <ProductComponent />
      </div>
      <h1>Shopping Cart</h1>
      <div className="shopping">
        <CartSummary cart={cart} />
        <CartDetail cart={cart} cartProducts={cartProducts} on RemoveFromCart={removeFromCart} />
        <CartCheckout onCheckout={checkout} />
      </div>
    </div>
        );
}

export default App;
