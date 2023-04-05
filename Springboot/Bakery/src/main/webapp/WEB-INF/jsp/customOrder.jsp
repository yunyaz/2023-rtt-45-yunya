<jsp:include page="include/header.jsp" />

<section class="py-5" style="background-color: #ede6f1; height: 1100px">
    <div class="container pb-5 text-left">
        <h2>Custom Order</h2>
        <br>
        <h5>Please note that there is a minimum of 14 days notice for all custom work.</h4>
    </div>
    <div class="container pb-3" style="width: 100%;">
        <div class="row">
            <div class="col-6">
                <form>
                    <div class="mb-4">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" aria-describedby="nameHelp">
                        <div id="nameHelp" class="form-text"></div>
                    </div>
                    <div class="mb-4">
                        <label for="email" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="email" aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text"></div>
                    </div>

                    <div class="mb-4">
                        <label for="eventDate" class="form-label">Event Date</label>
                        <input type="date" class="form-control" id="eventDate" aria-describedby="dateHelp">
                        <div id="dateHelp" class="form-text"></div>
                    </div>
                    <div class="row mb-4">
                        <div class="col">
                            <div>
                                <label for="cakeShape" class="form-label">Shape</label>
                            </div>
                            <select id="cakeShape" class="form-select">
                                <option selected></option>
                                <option value="Round">Round</option>
                                <option value="Sheet">Sheet</option>
                            </select>
                        </div>
                        <div class="col">
                            <div>
                                <label for="cakeSize" class="form-label">Size</label>
                            </div>
                            <select id="cakeSize" class="form-select">
                            </select>
                        </div>
                        <div class="col">
                            <div>
                                <label for="cakeType" class="form-label">Type</label>
                            </div>
                            <select id="cakeType" class="form-select">
                                <option selected></option>
                                <option value="Traditional">Traditional</option>
                                <option value="ButterCream">ButterCream</option>
                                <option value="Fondant">Fondant</option>
                            </select>
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col">
                            <div>
                                <label for="cakeFlavor" class="form-label mb-3">Cake Flavor</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="vanilla">
                                <label class="form-check-label" for="Vanilla">Vanilla</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="chocolate">
                                <label class="form-check-label" for="chocolate">Chocolate</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="white">
                                <label class="form-check-label" for="white">White</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="lemon">
                                <label class="form-check-label" for="lemon">Lemon</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="strawberry">
                                <label class="form-check-label" for="strawberry">Strawberry</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="redVelvet">
                                <label class="form-check-label" for="redVelvet">Red Velvet</label>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <label class="form-label mb-3">Cake Frosting</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="vanillaButterCream">
                                <label class="form-check-label" for="vanillaButterCream">Vanilla Buttercream</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="chocolateButterCream">
                                <label class="form-check-label" for="chocolateButterCream">Chocolate Buttercream</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="classicCreamCheese">
                                <label class="form-check-label" for="classicCreamCheese">Classic Cream Cheese</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="whippedCream">
                                <label class="form-check-label" for="whippedCream">Whipped Cream</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="strawberryButterCream">
                                <label class="form-check-label" for="strawberryButterCream">Strawberry Swirl Buttercream</label>
                            </div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="message" class="form-label">Message</label>
                        <textarea id="message" class="form-control" style="height: 100px;" aria-label="With textarea"></textarea>
                    </div>
                    <button id="submitBtn" type="button" class="btn mt-3 me-3">Submit Order</button>
                    <button id="cancelBtn" type="button" class="btn btn-secondary mt-3">Cancel</button>
                </form>
            </div>
            <div class="col-6">
                <div class="row justify-content-start">
                    <table id="tableRound1">
                        <tr>
                            <th>Round cake</th>
                            <th>Traditional</th>
                            <th>Buttercream</th>
                            <th>Fondant</th>
                        </tr>
                        <tr>
                            <td>6"</td>
                            <td>23</td>
                            <td>38</td>
                            <td>58</td>
                        </tr>
                        <tr>
                            <td>8"</td>
                            <td>34</td>
                            <td>49</td>
                            <td>71</td>
                        </tr>
                        <tr>
                            <td>10"</td>
                            <td>50</td>
                            <td>81</td>
                            <td>115</td>
                        </tr>
                        <tr>
                            <td>12"</td>
                            <td>72</td>
                            <td>103</td>
                            <td>178</td>
                        </tr>
                    </table>
                </div>
                <div class="row mt-5 justify-content-start">
                    <table id="tableRound2">
                        <tr>
                            <th>Sheet cake</th>
                            <th>Traditional</th>
                            <th>Buttercream</th>
                            <th>Fondant</th>
                        </tr>
                        <tr>
                            <td>1/4 Sheet Single</td>
                            <td>35</td>
                            <td>54</td>
                            <td>88</td>
                        </tr>
                        <tr>
                            <td>1/4 Sheet Double</td>
                            <td>68</td>
                            <td>98</td>
                            <td>118</td>
                        </tr>
                        <tr>
                            <td>1/2 Sheet Single</td>
                            <td>68</td>
                            <td>98</td>
                            <td>126</td>
                        </tr>
                        <tr>
                            <td>1/2 Sheet Double</td>
                            <td>101</td>
                            <td>131</td>
                            <td>151</td>
                        </tr>
                        <tr>
                            <td>Full Sheet Single</td>
                            <td>112</td>
                            <td>142</td>
                            <td>159</td>
                        </tr>
                        <tr>
                            <td>Full Sheet Double</td>
                            <td>172</td>
                            <td>203</td>
                            <td>233</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>


<script src="/pub/js/customOrder.js"></script>

<jsp:include page="include/footer.jsp" />