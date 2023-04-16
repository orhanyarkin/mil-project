import React, { useState } from 'react';

function CartCheckout({ cart }) {
  const [customerName, setCustomerName] = useState('');
  const [cardNumber, setCardNumber] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(`Customer Name: ${customerName}`);
    console.log(`Card Number: ${cardNumber}`);
    console.log('Submitting cart:', cart);
  }

  return (
    <div>
      <h1>Cart Checkout</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="customerName">Customer Name: </label>
          <input type="text" id="customerName" value={customerName} onChange={(e) => setCustomerName(e.target.value)} />
        </div>
        <div>
          <label htmlFor="cardNumber">Card Number: </label>
          <input type="text" id="cardNumber" value={cardNumber} onChange={(e) => setCardNumber(e.target.value)} />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default CartCheckout;
