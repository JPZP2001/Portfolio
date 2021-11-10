# Instrucciones:
# - Implementa el código necesario para que el código de cada uno de los ejercicios funcione.
# - No uses ActiveRecord, usa solo objetos "normales" de ruby.
# - Trabaja la implementación ejercicio por ejercicio.
# - Trabaja el ejercicio solo por 30min
# - No es necesario que termines todos los ejercicios.

#### Escribe aquí el código ####

#### Termina tu código ####

#### 1 ####
## Inventario ##
# iPod = Product.new('iPod', 229.00)
# iMac = Product.new('iMac', 1199.00)
# iPhone = Product.new('iPhone', 49.00)

# puts iPod.inspect
# puts iMac.inspect
# puts iPhone.inspect

# #### 2 ####
# ## Agregar productos al carrito ##
# cart = Cart.new()
# second_cart = Cart.new()

# cart.add(iMac)
# cart.add(iPhone)
# cart.add(iPod, 2)

# second_cart.add(iMac,2)
# second_cart.add(iPod)
# second_cart.add(iPod)
# second_cart.add(iPhone,5)

# puts cart.inspect
# puts second_cart.inspect
#
# #### 3 ####
# # Detalle de la compra ##
#
# cart.items.each do |item|
#   puts "#{item.name} - #{item.quantity} - #{item.price} US$"
# end
#
# #### 4 ####
# # Calcular el total del carrito ##
# puts "Los productos de tu carrito valen: #{cart.price}"
#
# #### 5 ####
# ## Descuentos: iPods 2 x 1, iMac => (iPhone - 20%) ##
# puts "Tu compra aplica un descuento de: #{cart.discount}."
# puts "El total de tu compra es de #{cart.total}."
#
# ### 6 ###
# puts "Agrega al inventario todos los productos de la familia mac con sus precios actuales de apple.com"
# puts "Puedes traer la informacion de http://store.apple.com/"

class Product
  attr_accessor :name, :price
  def initialize(name,price)
    @name = name
    @price = price
  end
  def print
    puts "Product name: "+name
    puts "Price : $"+price.to_s
  end
end

class CartItem
  attr_accessor :product, :quantity

  def initialize(product,quantity)
    @product = product
    @quantity = quantity
  end
end

class Cart
  attr_accessor :cartItems, :products

  def initialize(cartItems,products)
    @cartItems = cartItems
    @products = products
  end

  def total(cartItems)
    t = 0
    for cI in cartItems
      t = t + cI.quantity * cI.product.price
    end
    puts "Los productos de tu carrito valen = $"+t.to_s
  end

  def add(product, quantity)
    c = 0
    for p in cartItems
      if product.price == p.product.price
        p.quantity = p.quantity + quantity
        c = 1
      end
    end
    if c == 0
      cartItem = CartItem.new(product, quantity)
      cartItems << cartItem
    end
  end


  def printCart()
    for p in cartItems
    print p.product.print
    puts "Quantity: "+p.quantity.to_s
    puts " "
    end
  end

  def discount()
    ipodc = 0
    iphonec = 0
    imacc = 0
      if cI.product.price == 229.00
        ipodc = ipodc + 1
      elsif cI.product.price == 1199.00
      imacc = imacc +1
      else
        iphonec = iphonec + 1
      end
      if ipodc >= 2
      end
    end
end
puts "Welcome to JP's Store"
puts "---------- Inventory ----------"
iPod = Product.new("iPod", 229.00)
iMac = Product.new("iMac", 1199.00)
iPhone = Product.new("iPhone",49.00)
products = [iPod, iMac, iPhone]
puts iPod.print
puts iMac.print
puts iPhone.print
puts "----------Cart 1----------"
cartItems = []
cart1= Cart.new(cartItems,products)
cart1.add(iMac,1)
cart1.add(iPod,2)
cart1.add(iPhone,1)
cart1.printCart()
puts cart1.total(cartItems)

puts "----------Cart 2----------"
cartItems = []
cart2= Cart.new(cartItems, products)
cart2.add(iMac,1)
cart2.add(iMac, 3)
cart2.add(iPod,1)
cart2.printCart()
puts cart2.total(cartItems)
