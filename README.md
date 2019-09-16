# fyleProject

# Three endpoints:

1. login endpoint to generate jwt token -- Need to pass username and password in requestbody.

 # Endpoint -
      https://fyle-bank-16092019.herokuapp.com/login
      {
"username" : "user"
"password" - "password"
}

2. This endpoint fetches the branch based on ifsc code. Used offset and limit as per the requirement but was not necessary because only branch object will be returned.

# Endpoint - 
    https://fyle-bank-16092019.herokuapp.com/fyle/bank/bankDetails?ifsc=<>&offset=<>&limit=<>
    
3. This endpoint fetches all the branches based on bank name and city. Here offset and limit plays an important role to fetch the limitted number of objects using pagination.

# Endpoint - 
    https://fyle-bank-16092019.herokuapp.com/fyle/bank/branches?bank_name=<>&city=<>&offset=<>&limit=<>
    
 # Jwt token generated by login endpoint must be added in the header of last two endpoints. Using Authorization header.
 
 
 # Curl scripts
 
 # Use this command to generate JWT token:
 
 curl -i -d "{\"username\":\"user\",\"password\":\"password\"}" -H "Content-Type: application/json" https://fyle-bank-16092019.herokuapp.com/login
 
 # After generating token, copy and paste it in Authorization of other endpoints(Including Bearer).
 
#  Examples to showcase:

curl -v GET -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY5MDIzNzc5fQ.hfgqSrwOUKEWKcy9KPbu-DBHGpOhnG3KVtztaHo2fx-B0IEpb2KEhpm9A6GOTutRwXkiF8dpMxNq0ssBU17Yyg" --url "https://fyle-bank-16092019.herokuapp.com/fyle/bank/branches?bank_name=ABHYUDAYA%20COOPERATIVE%20BANK%20LIMITED&city=MUMBAI&offset=0&limit=10"

curl -v GET -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY5MDIzNzc5fQ.hfgqSrwOUKEWKcy9KPbu-DBHGpOhnG3KVtztaHo2fx-B0IEpb2KEhpm9A6GOTutRwXkiF8dpMxNq0ssBU17Yyg" --url "https://fyle-bank-16092019.herokuapp.com/fyle/bank/bankDetails?ifsc=ABHY0065001&offset=0&limit=10"
