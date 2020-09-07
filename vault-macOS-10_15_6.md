VAULT
=====

macOS Catalina 10.15.6
----------------------
<br/>

> $ sudo -E vault server -dev

*Look for* **Root Token**
```
The unseal key and root token are displayed below in case you want to seal/unseal the Vault or re-authenticate.

Unseal Key: l2GKiKeNfp03l0Y+FjdFInWZg+sRIWozegmSty8qk6A=
Root Token: s.VaHY3uZCajFaMFRvTOWam7kZ
```

> $ export VAULT_ADDR='http://127.0.0.1:8200

> $ export VAULT_TOKEN="s.VaHY3uZCajFaMFRvTOWam7kZ"

***

*Create file:* **[fileName.json]**

**Example:**

```json
{
    "spring.datasource.username": "root",
    "spring.datasource.password": "admin"
}
```

> $ vault kv put secret/catalog-service @catalog-service-credentials.json

> $ vault secrets list

```
Path          Type         Accessor              Description
----          ----         --------              -----------
cubbyhole/    cubbyhole    cubbyhole_ede731a0    per-token private secret storage
identity/     identity     identity_c65941af     identity store
secret/       kv           kv_67989d7a           key/value secret storage
sys/          system       system_e7dc1a37       system endpoints used for control, policy and debugging
```

> $ vault kv get secret/catalog-service

```
====== Metadata ======
Key              Value
---              -----
created_time     2020-09-06T20:32:13.889791Z
deletion_time    n/a
destroyed        false
version          1

=============== Data ===============
Key                           Value
---                           -----
spring.datasource.password    admin
spring.datasource.username    root
```
