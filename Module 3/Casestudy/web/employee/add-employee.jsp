<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Add Employee</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <link
      rel="stylesheet"
      href="/WEB-INF/lib/bootstrap/css/http_maxcdn.bootstrapcdn.com_bootstrap_4.5.2_css_bootstrap.css"
    />
    <script src="/WEB-INF/lib/bootstrap/js/http_ajax.googleapis.com_ajax_libs_jquery_3.5.1_jquery.js"></script>
    <script src="/WEB-INF/lib/bootstrap/js/http_cdnjs.cloudflare.com_ajax_libs_popper.js_1.16.0_umd_popper.js"></script>
    <script src="/WEB-INF/lib/bootstrap/js/http_maxcdn.bootstrapcdn.com_bootstrap_4.5.2_js_bootstrap.js"></script>
  </head>
  <body>
    <div class="bg-light border">
      <section class="clean-block clean-form dark">
        <div class="container">
          <div class="block-heading">
            <h2 class="text-primary">Add New Employee</h2>
          </div>
          <form action="#" method="post" role="form">
            <div class="form-group">
              <label for="name">Name*</label>
              <input
                type="text"
                class="form-control"
                id="name"
                name="name"
                placeholder="Enter name"
                required
              />
            </div>
            <div class="form-group">
              <label for="birthday">Birthday*</label>
              <input
                class="form-control"
                id="birthday"
                type="date"
                required
                name="birthday"
              />
            </div>
            <div class="form-group">
              <label for="idcard">ID Card</label>
              <input
                type="text"
                class="form-control"
                id="idcard"
                required
                name="idcard"
                placeholder="Enter ID Card"
              />
            </div>
            <div class="form-group">
              <label for="salary">Salary</label
              ><input
                type="text"
                class="form-control"
                id="salary"
                name="salary"
                placeholder="Enter Salary"
                required
              />
            </div>
            <div class="form-group">
              <label for="phone">Phone</label>
              <input
                type="tel"
                class="form-control"
                id="phone"
                name="phone"
                placeholder="0123-456-789"
                pattern="[0-9]{4}-[0-9]{3}-[0-9]{3}"
                required
              />
            </div>
            <div class="form-group">
              <label for="email">Email</label>
              <input
                type="email"
                class="form-control"
                id="email"
                name="email"
                placeholder="abc@mail.com"
                required
              />
            </div>
            <div class="form-group">
              <label for="address">Address</label>
              <input
                type="text"
                class="form-control"
                id="address"
                name="address"
                placeholder="Enter Address"
              />
            </div>
            <div class="form-group">
              <label for="position">Position</label>
              <select class="custom-select" id="position" name="position">
                <optgroup label="Choose Position">
                  <option value="1" selected>Receptionist</option>
                  <option value="2">Serve</option>
                  <option value="3">Specialist</option>
                  <option value="4">Supervisor</option>
                  <option value="5">Manager</option>
                  <option value="6">Director</option>
                </optgroup>
              </select>
            </div>
            <div class="form-group">
              <label for="educationDegree">Education Degree</label>
              <select
                class="custom-select"
                id="educationDegree"
                name="educationDegree"
              >
                <optgroup label="Select Education Degree">
                  <option value="1" selected>Intermediate</option>
                  <option value="2">Colleges</option>
                  <option value="3">University</option>
                  <option value="4">Graduated</option>
                </optgroup>
              </select>
            </div>
            <div class="form-group">
              <label for="division">Division</label>
              <select class="custom-select" id="division" name="division">
                <optgroup label="Select Division">
                  <option value="1" selected>Sale - Marketing</option>
                  <option value="2">Administrative</option>
                  <option value="3">Service</option>
                  <option value="4">Management</option>
                </optgroup>
              </select>
            </div>
            <div class="form-group">
              <label for="username">Username</label>
              <input
                type="text"
                class="form-control"
                id="username"
                name="username"
                placeholder="Enter Username"
              />
            </div>
            <hr style="margin-top: 30px; margin-bottom: 10px" />
            <div class="form-group">
              <button class="btn btn-primary btn-block" type="submit">
                <i class="fas fa-save"></i> Save
              </button>
            </div>
          </form>
        </div>
      </section>
    </div>
  </body>
</html>
