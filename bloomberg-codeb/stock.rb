# stock.rb
require 'sinatra'

get '/' do
  erb :index
end
get '/orders' do
  res = ""
  File.open("test.txt") do |f|
    f.each_line do |line|
      res += line
    end
  end
  erb :buysell, :locals => {:res => parse(res)}
end

get '/market' do
  marketData = ""
  File.open("ticker.txt") do |f|
    f.each_line do |line|
      marketData += line
    end
  end
  erb :market, :locals => {:marketData => parseTicker(marketData)}
end

helpers do
  def parse(res)
    parseArr = res.split(" ")
    bidaskArr = []
    i = 0
    id = 0
    while i < parseArr.length do
      if parseArr[i] == "BUY" || parseArr[i] == "SELL"
        temp = BidAsk.new(id, parseArr[i], parseArr[i+1], parseArr[i+2], parseArr[i+3], parseArr[i+4])
        bidaskArr.push(temp)
        i += 5
        id += 1
      else
        i += 3
      end
    end

    return bidaskArr
  end

  def parseTicker(data)
    parse = data.split(" ")
    puts(parse)
    marketData = []
    i = 0
    while i < parse.length do
      temp = Market.new(parse[i], parse[i+1], parse[i+2], parse[i+3], parse[i+4])
      marketData.push(temp)
      
    end

    return marketData
  end

  def getMaxId(data)
    i = 0
    maxId = 0
    maxIndex = 0
    puts(data)
    while i < data.length do
      if [maxId, data[i].getId().to_i].max > maxId
        maxId = data[i].getId().to_i
        maxIndex = i
      end
      i += 5
    end

    maxId -= 1

    return Market.new(data[i], data[i+1], data[i+2], data[i+3], data[i+4])
  end

end

class Market
  def initialize(id, stock, worth, bid, ask)
    @id = id
    @stock = stock
    @worth = worth
    @bid = bid
    @ask = ask

    def getId()
      return @id
    end
    def getStock() 
      return @stock
    end
    def getWorth()
      return @worth
    end
    def getBid()
      return @bid
    end
    def getAsk()
      return @ask
    end
  end
end

class BidAsk
  def initialize(id, type, stock, price, shares, cash)
    @id = id
    @type = type
    @stock = stock
    @price = price
    @shares = shares
    @cash = cash
  end

  def getId()
    return @id
  end
  def getType()
    return @type
  end
  
  def getStock()
    return @stock
  end
  
  def getPrice()
    return @price
  end

  def getShares()
    return @shares
  end

  def getCash()
    return @cash
  end
end
