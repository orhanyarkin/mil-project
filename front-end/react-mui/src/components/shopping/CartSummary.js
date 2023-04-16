import React from 'react';

function CartSummary({ cart }) {
  return (
    <div className="cart-summary">
      <h2>Cart Summary</h2>
      <ul>
        {cart ? (
          cart.map((item) => (
            <li key={item.product.id}>
              {item.product.name} - {item.quantity} pcs
            </li>
          ))
        ) : (
          <li>Your cart is empty</li>
        )}
      </ul>
    </div>
  );
}

export default CartSummary;

