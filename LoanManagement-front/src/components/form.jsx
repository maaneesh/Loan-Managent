import React, { useState } from "react";

const Form = () => {
  const [formData, setFormData] = useState({
    fullName: "",
    email: "",
    phone: "",
    loanAmount: "",
    loanType: "personal",
    loanDuration: "",
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const validate = () => {
    let tempErrors = {};
    if (!formData.fullName) tempErrors.fullName = "Full name is required";
    if (!formData.email) tempErrors.email = "Email is required";
    if (!formData.phone) tempErrors.phone = "Phone number is required";
    if (!formData.loanAmount) tempErrors.loanAmount = "Loan amount is required";
    if (!formData.loanDuration)
      tempErrors.loanDuration = "Loan duration is required";

    setErrors(tempErrors);
    return Object.keys(tempErrors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      console.log("Form submitted", formData);
      // Here you can integrate your API call or submit logic
    }
  };

  return (
    <form onSubmit={handleSubmit} className="loan-application-form">
      <h2>Loan Application Form</h2>

      <div>
        <label>Full Name:</label>
        <input
          type="text"
          name="fullName"
          value={formData.fullName}
          onChange={handleChange}
        />
        {errors.fullName && <span className="error">{errors.fullName}</span>}
      </div>

      <div>
        <label>Email:</label>
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
        />
        {errors.email && <span className="error">{errors.email}</span>}
      </div>

      <div>
        <label>Phone:</label>
        <input
          type="tel"
          name="phone"
          value={formData.phone}
          onChange={handleChange}
        />
        {errors.phone && <span className="error">{errors.phone}</span>}
      </div>

      <div>
        <label>Loan Amount ($):</label>
        <input
          type="number"
          name="loanAmount"
          value={formData.loanAmount}
          onChange={handleChange}
        />
        {errors.loanAmount && (
          <span className="error">{errors.loanAmount}</span>
        )}
      </div>

      <div>
        <label>Loan Type:</label>
        <select
          name="loanType"
          value={formData.loanType}
          onChange={handleChange}
        >
          <option value="personal">Personal</option>
          <option value="home">Home</option>
          <option value="car">Car</option>
          <option value="business">Business</option>
        </select>
      </div>

      <div>
        <label>Loan Duration (years):</label>
        <input
          type="number"
          name="loanDuration"
          value={formData.loanDuration}
          onChange={handleChange}
        />
        {errors.loanDuration && (
          <span className="error">{errors.loanDuration}</span>
        )}
      </div>

      <button type="submit">Submit Application</button>
    </form>
  );
};

export default Form;
