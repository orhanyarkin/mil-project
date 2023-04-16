import React from 'react';
import { Link } from 'react-router-dom';

function CartDetail({ cart, cartProducts, removeFromCart }) {
  return (
    <div className="cart-detail">
      <h2>Cart Detail</h2>
      <table>
        <thead>
          <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th>Remove</th>
          </tr>
        </thead>
        <tbody>
          {cartProducts && cartProducts.length > 0 ? (
            cartProducts.map((item) => (
              <tr key={item.product.id}>
                <td>{item.product.name}</td>
                <td>{item.quantity}</td>
                <td>{item.product.price}</td>
                <td>{item.product.price * item.quantity}</td>
                <td>
                  <button onClick={() => removeFromCart(item.product.id)}>
                    Remove
                  </button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5">Your cart is empty</td>
            </tr>
          )}
        </tbody>
      </table>
      <Link to="/cart/checkout">Proceed to checkout</Link>
    </div>
  );
}


export default CartDetail;
